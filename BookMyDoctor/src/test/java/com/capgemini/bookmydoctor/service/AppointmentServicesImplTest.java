package com.capgemini.bookmydoctor.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.capgemini.bookmydoctor.dto.Appointment;
import com.capgemini.bookmydoctor.exception.AppointmentException;
@SpringBootTest
class AppointmentServicesImplTest {

	@Autowired
	AppointmentServices appointmentServices;

	@Test
	void testAddAppointment() {

		Appointment appointment = new Appointment();

		appointment.setDoctorId(1);
		appointment.setPatientId(1);
		appointment.setAppointmentTime("1.30 PM");
		appointment.setAppointmentStatus("Not Approved");
		appointment.setAppointmentDate("28/02/2020");

		try {
			boolean status = appointmentServices.addAppointment(appointment);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(AppointmentException.class, () -> {
				appointmentServices.addAppointment(appointment);
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
		appointmentServices.searchAppointment(appointmentId);
		try {
			Appointment appointment = appointmentServices.searchAppointment(appointmentId);
			assertEquals(appointment != null, true);
		} catch (Exception e) {
			assertThrows(AppointmentException.class, () -> {
				appointmentServices.searchAppointment(appointmentId);

			});

		}
	}

	@Test
	void testGetAllAppointment() {
		List<Appointment> appointmentList = appointmentServices.getAllAppointment();
		assertNotNull(appointmentList);
	}

	@Test
	void testDeleteAppointment() {
		int appointmentId = 31;
		try {
			boolean status = appointmentServices.deleteAppointment(1);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(AppointmentException.class, () -> {
				appointmentServices.deleteAppointment(appointmentId);

			});
		}
	}
}

