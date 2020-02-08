package com.capgemini.bookmydoctor.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.bookmydoctor.dto.Contact;
import com.capgemini.bookmydoctor.exception.ContactException;

@Repository
public class ContactDaoImpl implements ContactDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	@Override
	public boolean addContact(Contact contact) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.persist(contact);
			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
		}
		entityManager.close();
		throw new ContactException("Contact messages Cannot be Added ");

	}

	@Override
	public boolean deleteContact(int contactId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Contact where contactId = : cid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("cid", contactId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		throw new ContactException("Contact Messages Cannot be deleted ");
	}

	@Override
	public ArrayList<Contact> getAllContact() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from Contact ";
		Query query = entityManager.createQuery(jpql, Contact.class);
		ArrayList<Contact> contactList = (ArrayList<Contact>) query.getResultList();
		if (contactList != null && contactList.size() != 0) {
			return contactList;
		}
		throw new ContactException("Contact Messages Are not Present ");
	}

}
