package com.capgemini.bookmydoctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.bookmydoctor.dto.Contact;
import com.capgemini.bookmydoctor.response.ContactResponse;
import com.capgemini.bookmydoctor.service.ContactServices;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class ContactController {

	@Autowired
	ContactServices contactServices;
	
	@PostMapping(path = "/add-mail", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ContactResponse addContact(@RequestBody Contact contact) {
		ContactResponse contactResponse = new ContactResponse();
		if (contactServices.addContact(contact)) {
			contactResponse.setStatusCode(201);
			contactResponse.setMessage("Success");
			contactResponse.setDescription("Contact Added Successfully");
		}
		return contactResponse;
	}
	
	@GetMapping(path = "/get-all-mails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ContactResponse getAllContact() {
		ContactResponse contactResponse = new ContactResponse();
		List<Contact> ContactList = contactServices.getAllContact();
		if (ContactList.size() != 0) {
			contactResponse.setStatusCode(201);
			contactResponse.setMessage("Success");
			contactResponse.setDescription("Contact Found Successfully");
			contactResponse.setContact(ContactList);
			return contactResponse;
		}
		return contactResponse;
	}
	
	@DeleteMapping(path = "/delete-mail/{contactId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ContactResponse deleteContact(@PathVariable("contactId") int contactId) {
		ContactResponse contactResponse = new ContactResponse();
		if (contactServices.deleteContact(contactId)) {
			contactResponse.setStatusCode(201);
			contactResponse.setMessage("Success");
			contactResponse.setDescription("Contact Deleted Successfully");
		}
		return contactResponse;
	}

	
}
