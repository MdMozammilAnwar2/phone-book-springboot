/**
 * 
 */
package com.anwar.phonebook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anwar.phonebook.bindings.ContactForm;
import com.anwar.phonebook.entities.Contact;
import com.anwar.phonebook.repository.ContactRepository;

/**
 * @author MD MOZAMMIL ANWAR
 *
 */
@Service("ContactService")
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;

	@Override
	public List<ContactForm> getContacts() {
		// now fetch the latest data from db and return
		ArrayList<ContactForm> contactList = new ArrayList<>();
		List<Contact> allContact = contactRepo.findAll();
		for (Contact entity : allContact) {
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			contactList.add(form);
		}
		return contactList;
	}

	@Override
	public String saveContact(ContactForm contactForm) {
		// we have recieved form binding object as per parameter
		// reporitory save(entity) method expecting entity object
		// so copy the data from formbinding object to entity objec
		Contact contact = new Contact();
		BeanUtils.copyProperties(contactForm, contact);
		contact.setIsActive(true);
		Contact save = contactRepo.save(contact);
		System.out.println("saved data >>>"+save);
		if (save.getContactId() != null) {
			return "SUCCESS";
		}
		return "FAILURE";
	}

	@Override
	public ContactForm editContact(Integer contactId) {
		// TODO edit the contact
		Optional<Contact> findById = contactRepo.findById(contactId);
		if(findById.isPresent()) {
			Contact contact = findById.get();
			ContactForm form=new ContactForm();
			BeanUtils.copyProperties(contact, form);
			return form;
		}
		return null;
	}

	@Override
	public List<ContactForm> deleteContact(Integer contactId) {
		// here we will be deleting
		contactRepo.deleteById(contactId);
		// now fetch the latest data from db and return
		ArrayList<ContactForm> contactList = new ArrayList<>();
		List<Contact> allContact = contactRepo.findAll();
		for (Contact entity : allContact) {
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			contactList.add(form);
		}
		return contactList;
	}

}
