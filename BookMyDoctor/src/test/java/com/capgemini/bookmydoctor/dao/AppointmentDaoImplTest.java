package com.capgemini.bookmydoctor.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.bookmydoctor.dto.Appointment;
import com.capgemini.bookmydoctor.exception.AppointmentException;


@SpringBootTest
class AppointmentDaoImplTest {
	@Autowired
	AppointmentDao appointmentDao;

	@Test
	void testAddAppointment() {

		Appointment appointment = new Appointment();

		appointment.setDoctorId(1);
		appointment.setPatientId(1);
		appointment.setAppointmentTime("12.30 AM");
		appointment.setAppointmentStatus("Aggred");
		appointment.setAppointmentDate("31/01/2020");

		try {
			boolean status = appointmentDao.addAppointment(appointment);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(AppointmentException.class, () -> {
				appointmentDao.addAppointment(appointment);
			});
		}
	}

	@Test
	void testUpdateAppointment() {
		Appointment appointment = new Appointment();
		appointment.setDoctorId(2);
		appointment.setPatientId(2);
		appointment.setAppointmentStatus("not approved");
		appointment.setAppointmentDate("01/02/2020");
		appointment.setAppointmentTime("4.30 PM");

	}

	@Test
	void testSearchAppointment() {
		int appointmentId = 33;
		appointmentDao.searchAppointment(appointmentId);
		try {
			Appointment appointment = appointmentDao.searchAppointment(appointmentId);
			assertEquals(appointment != null, true);
		} catch (Exception e) {
			assertThrows(AppointmentException.class, () -> {
				appointmentDao.searchAppointment(appointmentId);

			});

		}
	}
	
	@Test
	void testGetAllAppointment() {
		List<Appointment> appointmentList = appointmentDao.getAllAppointment();
		assertNotNull(appointmentList);
	}

	@Test
	void testDeleteAppointment() {
		int appointmentId = 31;
		try {
			boolean status = appointmentDao.deleteAppointment(1);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(AppointmentException.class, () -> {
				appointmentDao.deleteAppointment(appointmentId);

			});
		}
	}
}
