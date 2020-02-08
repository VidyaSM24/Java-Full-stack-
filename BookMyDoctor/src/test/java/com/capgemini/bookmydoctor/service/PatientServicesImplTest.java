package com.capgemini.bookmydoctor.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.capgemini.bookmydoctor.dto.Patient;
import com.capgemini.bookmydoctor.exception.DoctorException;
import com.capgemini.bookmydoctor.exception.PatientException;

@SpringBootTest
class PatientServicesImplTest {
	@Autowired
	PatientServices patientService;

	@Test
	void testAddPatient() {
		Patient patient = new Patient();

		patient.setPatientFirstName("Chethan");
		patient.setPatientLastName("Gowda");
		patient.setGender("Male");
		patient.setAddress("55,Sai Nilayam ,Bangalore");
		patient.setHealthIssue("Headache");
		patient.setPatientEmail("chethan@gmail.com");
		patient.setPhoneNo(8879749);

		try {
			boolean status = patientService.addPatient(patient);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(PatientException.class, () -> {
				patientService.addPatient(patient);
			});
		}
	}

	@Test
	void testUpdatePatient() {
		Patient patient = new Patient();
		patient.setPatientFirstName("Saniya");
		patient.setPatientLastName("Fathima");
		patient.setGender("Female");
		patient.setHealthIssue("Headache");
		patient.setPatientEmail("fathima@gmail.com");
		patient.setAddress("56, Shree Homes,Jayanagar");
		patient.setPhoneNo(947858476);
	}

	@Test
	void testDeletePatient() {
		String patientEmail = "vidy@g.com";
		try {
			boolean status = patientService.deletePatient(patientEmail);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(DoctorException.class, () -> {
				patientService.deletePatient(patientEmail);

			});
		}
	}

	@Test
	void testSearchPatient() {
		int patientId = 98;
		patientService.searchPatient(patientId);
		try {
			Patient patient = patientService.searchPatient(patientId);
			assertEquals(patient != null, true);
		} catch (Exception e) {
			assertThrows(DoctorException.class, () -> {
				patientService.searchPatient(patientId);

			});

		}
	}

	@Test
	void testGetAllPatient() {
		List<Patient> patientList = patientService.getAllPatient();
		assertNotNull(patientList);
	}

}
