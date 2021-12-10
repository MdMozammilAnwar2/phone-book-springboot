/**
 * 
 */
package com.anwar.phonebook.service;

import java.util.List;

import com.anwar.phonebook.bindings.ContactForm;

/**
 * @author MD MOZAMMIL ANWAR
 *
 */
public interface ContactService {
	public List<ContactForm> getContacts();

	public String saveContact(ContactForm contactForm);

	public ContactForm editContact(Integer contactId);

	public List<ContactForm> deleteContact(Integer contactId);
}
