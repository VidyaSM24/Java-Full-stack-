package com.capgemini.bookmydoctor.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.bookmydoctor.dto.Appointment;
import com.capgemini.bookmydoctor.exception.AppointmentException;

@Repository
public class AppointmentDaoImpl implements AppointmentDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addAppointment(Appointment appointment) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.persist(appointment);
			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
		}
		entityManager.close();
		throw new AppointmentException("Appointment Cannot be Added ");

	}

	@Override
	public boolean updateAppointment(Appointment appointment) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Appointment set appointmentDate=:adate, appointmentTime=:atime, "
				+ "appointmentStatus=:sts where appointmentId = : aid";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("adate", appointment.getAppointmentDate());
		query.setParameter("atime", appointment.getAppointmentTime());
		query.setParameter("sts", appointment.getAppointmentStatus());
		query.setParameter("aid", appointment.getAppointmentId());

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		entityManager.close();
		throw new AppointmentException("Sorry Appointment cannot be  Modified ");

	}

	@Override
	public boolean deleteAppointment(int appointmentId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Appointment where appointmentId = : aid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("aid", appointmentId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		throw new AppointmentException("Appointment Cannot be deleted ");

	}

	@Override
	public Appointment searchAppointment(int appointmentId) {
		Appointment appointment1 = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		appointment1 = entityManager.find(Appointment.class, appointmentId);
		if (appointment1 != null) {
			return appointment1;
		}
		throw new AppointmentException("Appointment Cannot be Found ");

	}

	@Override
	public ArrayList<Appointment> getAllAppointment() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from Appointment ";
		Query query = entityManager.createQuery(jpql, Appointment.class);
		ArrayList<Appointment> appointmentList = (ArrayList<Appointment>) query.getResultList();
		if (appointmentList != null && appointmentList.size() != 0) {
			return appointmentList;
		}
		throw new AppointmentException("Appointment Details Are not Present ");

	}

	@Override
	public ArrayList<Appointment> getAllAppointmentDoctor(int doctorId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from Appointment where doctorId=:did ";
		Query query = entityManager.createQuery(jpql, Appointment.class);
		query.setParameter("did", doctorId);
		ArrayList<Appointment> appointmentList = (ArrayList<Appointment>) query.getResultList();
		if (appointmentList != null && appointmentList.size() != 0) {
			return appointmentList;
		}
		throw new AppointmentException("Appointment Details Are not Present ");

	}

	@Override
	public ArrayList<Appointment> getAllAppointmentPatient(int patientId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from Appointment where patientId=:pid ";
		Query query = entityManager.createQuery(jpql, Appointment.class);
		query.setParameter("pid", patientId);
		ArrayList<Appointment> appointmentList = (ArrayList<Appointment>) query.getResultList();
		if (appointmentList != null && appointmentList.size() != 0) {
			return appointmentList;
		}
		throw new AppointmentException("Appointment Details Are not Present ");
	}

}
