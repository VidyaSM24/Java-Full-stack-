package com.capgemini.appdevelopement.services;

import java.util.List;

import com.capgemini.appdevelopement.bean.ContactBean;
import com.capgemini.appdevelopement.dao.ContactDao;
import com.capgemini.appdevelopement.factory.ContactFactory;

public class ContactServicesImpl implements ContactServices {
	ContactDao dao= ContactFactory.instanceOfContactDAOImpl();

	@Override
	public boolean insertContact(ContactBean contact) {
		return dao.insertContact(contact);
	}

	@Override
	public boolean deleteContact(long number, String name) {
		return dao.deleteContact(number, name);
	}

	@Override
	public boolean editContact(long number, String name) {
		return dao.editContact(number, name);

	}

	@Override
	public List<ContactBean> getAllContact() {
		return dao.getAllContact();
	}
}