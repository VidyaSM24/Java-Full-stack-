package com.capgemini.bookmydoctor.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.bookmydoctor.dto.Ratings;
import com.capgemini.bookmydoctor.exception.RatingsException;

@Repository
public class RatingsDaoImpl implements RatingsDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addRatings(Ratings ratings) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.persist(ratings);
			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
		}
		entityManager.close();
		throw new RatingsException("Ratings Cannot be Added ");

	}

	@Override
	public boolean updateRatings(Ratings ratings) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Ratings set ratings=:rtng, feedback=:fdbc where ratingId = :rid";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("rtng", ratings.getRatings());
		query.setParameter("fdbc", ratings.getFeedback());
		query.setParameter("rid", ratings.getRatingId());

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		entityManager.close();
		throw new RatingsException("Sorry Ratings cannot be  Modified ");

	}

	@Override
	public boolean deleteRatings(int ratingId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Ratings where ratingId = : rid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("rid", ratingId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		throw new RatingsException("Ratings Cannot be deleted ");
	}

	@Override
	public Ratings searchRatings(int ratingId) {
		Ratings ratings1 = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		ratings1 = entityManager.find(Ratings.class, ratingId);
		if (ratings1 != null) {
			return ratings1;
		}
		throw new RatingsException("Ratings Cannot be Found ");

	}

	@Override
	public ArrayList<Ratings> getAllRatings() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from Ratings ";
		Query query = entityManager.createQuery(jpql, Ratings.class);
		ArrayList<Ratings> ratingList = (ArrayList<Ratings>) query.getResultList();
		if (ratingList != null && ratingList.size() != 0) {
			return ratingList;
		}
		throw new RatingsException("Ratings Details Are not Present ");

	}

}

