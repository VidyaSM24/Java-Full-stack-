package com.capgemini.bookmydoctor.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bookmydoctor.dao.ContactDao;
import com.capgemini.bookmydoctor.dto.Contact;

@Service
public class ContactServicesImpl implements ContactServices {

	@Autowired
	ContactDao contactDao;
	
	@Override
	public boolean addContact(Contact contact) {
		return contactDao.addContact(contact);
	}

	@Override
	public boolean deleteContact(int contactId) {
		return contactDao.deleteContact(contactId);
	}

	@Override
	public ArrayList<Contact> getAllContact() {
		return contactDao.getAllContact();
	}

}