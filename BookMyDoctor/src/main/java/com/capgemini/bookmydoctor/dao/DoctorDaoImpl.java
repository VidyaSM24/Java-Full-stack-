package com.capgemini.bookmydoctor.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.bookmydoctor.dto.Doctor;
import com.capgemini.bookmydoctor.exception.DoctorException;

@Repository
public class DoctorDaoImpl implements DoctorDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addDoctor(Doctor doctor) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.persist(doctor);
			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
		}
		entityManager.close();
		throw new DoctorException("Doctor Cannot be Added Please Enter Doctor Id");

	}

	@Override
	public boolean updateDoctor(Doctor doctor) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Doctor set firstName = :fname, lastName=:lname,doctorId=:did, specialization=:spcl,"
				+ "ratings=:rating, doctorEmail=:eml, clinicName=: clinic where doctorEmail=:eml";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("fname", doctor.getFirstName());
		query.setParameter("lname", doctor.getLastName());
		query.setParameter("spcl", doctor.getSpecialization());
		query.setParameter("rating", doctor.getRatings());
		query.setParameter("eml", doctor.getDoctorEmail());
		query.setParameter("clinic", doctor.getClinicName());
		query.setParameter("did", doctor.getDoctorId());

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		entityManager.close();
		throw new DoctorException("Sorry Doctor cannot be  Modified ");

	}

	@Override
	public boolean deleteDoctor(String doctorEmail) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Doctor where doctorEmail = :eml ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("eml", doctorEmail);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		throw new DoctorException("Doctor Cannot be deleted ");
	}

	@Override
	public Doctor searchDoctor(int doctorId) {
		Doctor doctor1 = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		doctor1 = entityManager.find(Doctor.class, doctorId);
		if (doctor1 != null) {
			return doctor1;
		}
		throw new DoctorException("User Cannot be Found Enter The Doctor Id");

	}

	@Override
	public ArrayList<Doctor> getAllDoctor() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from Doctor order by ratings desc ";
		Query query = entityManager.createQuery(jpql, Doctor.class);
		ArrayList<Doctor> doctor = (ArrayList<Doctor>) query.getResultList();
		if (doctor != null && doctor.size() != 0) {
			return doctor;
		}
		throw new DoctorException("Doctor Details Are not Present ");
	}

	@Override
	public boolean updateDoctorRatings(Doctor doctor) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Doctor set ratings=:rating where doctorId = :did";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("rating", doctor.getRatings());
		query.setParameter("did", doctor.getDoctorId());

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		entityManager.close();
		throw new DoctorException("Sorry Doctor Ratings cannot be  Updated ");

	}

}
