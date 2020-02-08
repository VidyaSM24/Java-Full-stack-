package com.capgemini.bookmydoctor.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.bookmydoctor.dto.Patient;
import com.capgemini.bookmydoctor.exception.DoctorException;
import com.capgemini.bookmydoctor.exception.PatientException;

@SpringBootTest
class PatientDaoImplTest {
	@Autowired
	PatientDao patientDao;

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
			boolean status = patientDao.addPatient(patient);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(PatientException.class, () -> {
				patientDao.addPatient(patient);
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
	void testSearchPatient() {
		int patientId = 0;
		patientDao.searchPatient(patientId);
		try {
			Patient patient = patientDao.searchPatient(patientId);
			assertEquals(patient != null, true);
		} catch (Exception e) {
			assertThrows(DoctorException.class, () -> {
				patientDao.searchPatient(patientId);

			});

		}
	}

	@Test
	void testGetAllPatient() {
		List<Patient> patientList = patientDao.getAllPatient();
		assertNotNull(patientList);
	}

	@Test
	void testDeletePatient() {
		String patientEmail = "chethan@gmail.com";
		try {
			boolean status = patientDao.deletePatient(patientEmail);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(DoctorException.class, () -> {
				patientDao.deletePatient(patientEmail);

			});
		}
	}
}
