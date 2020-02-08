package com.capgemini.bookmydoctor.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.capgemini.bookmydoctor.dto.Doctor;
import com.capgemini.bookmydoctor.exception.DoctorException;
@SpringBootTest
class DoctorServicesImplTest {

	@Autowired
	DoctorServices doctorServices;

	@Test
	void testAddDoctor() {
		Doctor doctor = new Doctor();
		
		doctor.setFirstName("Mythri");
		doctor.setLastName("Pujar");
		doctor.setSpecialization("Pediatrician");
		doctor.setDoctorEmail("mythripujar@gmail.com");
		doctor.setClinicName("Cloud Nine Hospital");
		doctor.setRatings("5");

		try {
			boolean status = doctorServices.addDoctor(doctor);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(DoctorException.class, () -> {
				doctorServices.addDoctor(doctor);
			});
		}
	}

	@Test
	void testUpdateDoctor() {
		Doctor doctor = new Doctor();
		doctor.setFirstName("Nivedhitha");
		doctor.setLastName("Bhat");
		doctor.setSpecialization("General Medicine");
		doctor.setClinicName("Appolo Hospital");
		
	}

	@Test
	void testDeleteDoctor() {
		String doctorEmail = "mythripujar@gmail.com";
		try {
			boolean status = doctorServices.deleteDoctor("mythripujar@gmail.com");
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(DoctorException.class, () -> {
				doctorServices.deleteDoctor(doctorEmail);
	
			});
		}
	}

	@Test
	void testSearchDoctor() {
		int doctorId = 3;
		doctorServices.searchDoctor(doctorId);
		try {
			Doctor doctor = doctorServices.searchDoctor(doctorId);
			assertEquals(doctor != null, true);
		} catch (Exception e) {
			assertThrows(DoctorException.class, () -> {
				doctorServices.searchDoctor(doctorId);

			});

		}
	}

	@Test
	void testGetAllDoctor() {
		List<Doctor> doctorList=doctorServices.getAllDoctor();
		assertNotNull(doctorList);
		
	}
}
