package com.capgemini.bookmydoctor.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.bookmydoctor.dto.History;
import com.capgemini.bookmydoctor.exception.HistoryException;

@Repository
public class HistoryDaoImpl implements HistoryDao{

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	@Override
	public boolean addHistory(History history) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.persist(history);
			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
		}
		entityManager.close();
		throw new HistoryException("History Cannot be Added ");

	}

	@Override
	public boolean deleteHistory(int historyId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from History where historyId = : hid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("hid", historyId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		throw new HistoryException("History Cannot be deleted ");
	}

	@Override
	public ArrayList<History> getAllHistory() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from History ";
		Query query = entityManager.createQuery(jpql, History.class);
		ArrayList<History> historyList = (ArrayList<History>) query.getResultList();
		if (historyList != null && historyList.size() != 0) {
			return historyList;
		}
		throw new HistoryException("History Details Are not Present ");
	}

		
}
