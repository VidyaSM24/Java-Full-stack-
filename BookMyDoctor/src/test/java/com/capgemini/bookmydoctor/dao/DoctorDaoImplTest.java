package com.capgemini.bookmydoctor.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.bookmydoctor.dto.Doctor;

import com.capgemini.bookmydoctor.exception.DoctorException;

@SpringBootTest
class DoctorDaoImplTest {

	@Autowired
	DoctorDao doctorDao;

	@Test
	void testAddDoctor() {
		Doctor doctor = new Doctor();

		doctor.setFirstName("Vidya");
		doctor.setLastName("Malnad");
		doctor.setSpecialization("Cardiologist");
		doctor.setDoctorEmail("vidyamalnadsm@gmail.com");
		doctor.setClinicName("Appolo Hospital");
		//doctor.setRatings("5");

		try {
			boolean status = doctorDao.addDoctor(doctor);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(DoctorException.class, () -> {
				doctorDao.addDoctor(doctor);
			});
		}
	}

	@Test
	void testUpdateDoctor() {
		Doctor doctor = new Doctor();
		doctor.setFirstName("Malnad");
		doctor.setLastName("Vidya");
		doctor.setSpecialization("Ortho");
		doctor.setDoctorEmail("vidyasm@gmail.com");
		doctor.setClinicName("Wales Hospital");
		//doctor.setRatings("4");

	}

	@Test
	void testSearchDoctor() {
		int doctorId=1;
		doctorDao.searchDoctor(doctorId);
		try {
			Doctor doctor = doctorDao.searchDoctor(doctorId);
			assertEquals(doctor != null, true);
		} catch (Exception e) {
			assertThrows(DoctorException.class, () -> {
				doctorDao.searchDoctor(doctorId);

			});

		}
	}

	@Test
	void testGetAllDoctor() {
		List<Doctor> doctorList = doctorDao.getAllDoctor();
		assertNotNull(doctorList);

	}

	@Test
	void testDeleteDoctor() {
		String doctorEmail = "vidyamalnadsm@gmail.com";
		try {
			boolean status = doctorDao.deleteDoctor(doctorEmail);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(DoctorException.class, () -> {
				doctorDao.deleteDoctor(doctorEmail);

			});
		}
	}
}
