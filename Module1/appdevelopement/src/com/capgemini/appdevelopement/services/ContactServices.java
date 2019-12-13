package com.capgemini.appdevelopement.services;

import java.util.List;

import com.capgemini.appdevelopement.bean.ContactBean;

public interface ContactServices {
	public  boolean insertContact(ContactBean contact);
	public boolean deleteContact(long number,String name);
	public boolean editContact(long number,String name);
	public List<ContactBean> getAllContact();
	
	
	

}



