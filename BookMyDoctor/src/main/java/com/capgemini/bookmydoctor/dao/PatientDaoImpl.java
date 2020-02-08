package com.capgemini.bookmydoctor.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.bookmydoctor.dto.Patient;
import com.capgemini.bookmydoctor.exception.PatientException;

@Repository
public class PatientDaoImpl implements PatientDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addPatient(Patient patient) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.persist(patient);
			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
		}
		entityManager.close();
		throw new PatientException("Patient Cannot be Added Please Enter Doctor Id");

	}

	@Override
	public boolean updatePatient(Patient patient) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Patient set patientFirstName = :fname, patientLastName=:lname, patientId = :pid ,"
				+ " phoneNo=: phone, gender=: gender, address=: add, healthIssue=: issue  where patientEmail =:email";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("fname", patient.getPatientFirstName());
		query.setParameter("lname", patient.getPatientLastName());
		query.setParameter("email", patient.getPatientEmail());
		query.setParameter("phone", patient.getPhoneNo());
		query.setParameter("gender", patient.getGender());
		query.setParameter("add", patient.getAddress());
		query.setParameter("issue", patient.getHealthIssue());
		query.setParameter("pid", patient.getPatientId());

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		entityManager.close();
		throw new PatientException("Sorry Patient cannot be  Modified ");

	}

	@Override
	public boolean deletePatient(String patientEmail) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Patient where patientEmail = : eml ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("eml", patientEmail);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		throw new PatientException("Patient Cannot be deleted Enter Valid Patient Id");

	}

	@Override
	public Patient searchPatient(int patientId) {
		Patient patient1 = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		patient1 = entityManager.find(Patient.class, patientId);
		if (patient1 != null) {
			return patient1;
		}
		throw new PatientException("Patient Cannot be Found Enter The Doctor Id");

	}

	@Override
	public ArrayList<Patient> getAllPatient() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from Patient ";
		Query query = entityManager.createQuery(jpql, Patient.class);
		ArrayList<Patient> patientList = (ArrayList<Patient>) query.getResultList();
		if (patientList != null && patientList.size() != 0) {
			return patientList;
		}
		throw new PatientException("Patient Details Are not Present ");

	}

}
