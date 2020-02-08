package com.capgemini.bookmydoctor.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.capgemini.bookmydoctor.dto.Availability;
import com.capgemini.bookmydoctor.exception.AppointmentException;
import com.capgemini.bookmydoctor.exception.AvailabilityException;

@SpringBootTest
class AvailabilityDaoImplTest {
	@Autowired
	AvailabilityDao availabilityDao;

	@Test
	void testAddAvailability() {

		Availability availability = new Availability();

		availability.setAvailability("Not Available");
		availability.setDoctorId(1);
		availability.setFromDate("31/03/2020");
		availability.setToDate("5/04/2020");
		try {
			boolean status = availabilityDao.addAvailability(availability);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(AppointmentException.class, () -> {
				availabilityDao.addAvailability(availability);
			});
		}
	}

	@Test
	void testUpdateAvailability() {

		Availability availability = new Availability();
		availability.setAvailability("not available");
		availability.setDoctorId(1);
		availability.setFromDate("01/02/2020");
		availability.setToDate("02/02/2020");

	}

	@Test
	void testSearchAvailability() {
		int availabilityId = 44;
		availabilityDao.searchAvailability(availabilityId);
		try {
			Availability availability = availabilityDao.searchAvailability(availabilityId);
			assertEquals(availability != null, true);
		} catch (Exception e) {
			assertThrows(AvailabilityException.class, () -> {
				availabilityDao.searchAvailability(availabilityId);

			});

		}
	}

	@Test
	void testGetAllAvailability() {
		List<Availability> availabilityList = availabilityDao.getAllAvailability();
		assertNotNull(availabilityList);
	}

	@Test
	void testDeleteAvailability() {
		int availabilityId = 43;
		try {
			boolean status = availabilityDao.deleteAvailability(availabilityId);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(AvailabilityException.class, () -> {
				availabilityDao.deleteAvailability(availabilityId);

			});
		}
	}
}
