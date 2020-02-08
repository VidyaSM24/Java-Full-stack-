package com.capgemini.bookmydoctor.dao;

import java.util.ArrayList;

import com.capgemini.bookmydoctor.dto.Contact;

public interface ContactDao {

	public boolean addContact(Contact contact);

	public boolean deleteContact(int contactId);

	public ArrayList<Contact> getAllContact();
}
