/**
 * 
 */
package com.anwar.phonebook.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anwar.phonebook.bindings.ContactForm;
import com.anwar.phonebook.service.ContactService;



/**
 * @author MD MOZAMMIL ANWAR
 *
 */
@CrossOrigin
@RestController
public class ContactRestController {

	@Autowired(required = true)
	private ContactService service;
	@GetMapping("/")
	public String welcome() {
		return "Welcome to the phone book";
	}
	
	@PostMapping("/save")
	public HashMap<String, Object> saveContact(@RequestBody ContactForm form) {
		System.out.println("data coming to controller>>>"+form);
		String saveContact = service.saveContact(form);
		 HashMap<String, Object> map = new HashMap<>();
		 map.put("result", "SUCCESS");
		 return map;
	}
	@GetMapping("/contacts")
	public List<ContactForm> viewAllContacts(){
		return service.getContacts();
	}
	
	@GetMapping("/edit/{contactId}")
	public ContactForm editContact(@PathVariable Integer contactId) {
		return service.editContact(contactId);
	}
	@DeleteMapping("/delete/{contactId}")
	public List<ContactForm> deleteContact(@PathVariable Integer contactId){
		return service.deleteContact(contactId);
	}
}

