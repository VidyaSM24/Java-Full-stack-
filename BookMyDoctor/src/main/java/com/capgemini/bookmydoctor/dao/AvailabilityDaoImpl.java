package com.capgemini.bookmydoctor.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.bookmydoctor.dto.Availability;
import com.capgemini.bookmydoctor.exception.AvailabilityException;

@Repository
public class AvailabilityDaoImpl implements AvailabilityDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addAvailability(Availability availability) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.persist(availability);
			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
		}
		entityManager.close();
		throw new AvailabilityException("Availability Cannot be Added ");

	}

	@Override
	public boolean updateAvailability(Availability availability) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Availability set fromDate=:fdate, toDate=:tdate, availability=: avlble where availabilityId = :aid";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("fdate", availability.getFromDate());
		query.setParameter("tdate", availability.getToDate());
		query.setParameter("avlble", availability.getAvailability());
		query.setParameter("aid", availability.getAvailabilityId());

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		entityManager.close();
		throw new AvailabilityException("Sorry Ratings cannot be  Modified ");

	}

	@Override
	public boolean deleteAvailability(int availabilityId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Availability where availabilityId = : aid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("aid", availabilityId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		throw new AvailabilityException("Availability Cannot be deleted ");

	}

	@Override
	public Availability searchAvailability(int availabilityId) {
		Availability availability1 = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		availability1 = entityManager.find(Availability.class, availabilityId);
		if (availability1 != null) {
			return availability1;
		}
		throw new AvailabilityException("Availability Cannot be Found ");

	}

	@Override
	public ArrayList<Availability> getAllAvailability() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from Availability ";
		Query query = entityManager.createQuery(jpql, Availability.class);
		ArrayList<Availability> availabilityList = (ArrayList<Availability>) query.getResultList();
		if (availabilityList != null && availabilityList.size() != 0) {
			return availabilityList;
		}
		throw new AvailabilityException("Ratings Details Are not Present ");

	}

}
