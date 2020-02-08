package com.capgemini.bookmydoctor.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.capgemini.bookmydoctor.dto.Availability;
import com.capgemini.bookmydoctor.exception.AppointmentException;
import com.capgemini.bookmydoctor.exception.AvailabilityException;

class AvailabilityServicesImplTest {
	@Autowired
	AvailabilityServices availabilityServices;

	@Test
	void testAddAvailability() {

		Availability availability = new Availability();

		availability.setAvailability("Available");
		availability.setDoctorId(2);
		availability.setFromDate("06/03/2020");
		availability.setToDate("07/04/2020");
		try {
			boolean status = availabilityServices.addAvailability(availability);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(AppointmentException.class, () -> {
				availabilityServices.addAvailability(availability);
			});
		}
	}

//	@Test
//	void testUpdateAvailability() {
//
//		Availability availability = new Availability();
//		availability.setAvailability("not available");
//		availability.setDoctorId(1);
//		availability.setFromDate("05/04/2020");
//		availability.setToDate("09/04/2020");
//
//	}
//
//	@Test
//	void testSearchAvailability() {
//		int availabilityId = 39;
//		availabilityServices.searchAvailability(availabilityId);
//		try {
//			Availability availability = availabilityServices.searchAvailability(availabilityId);
//			assertEquals(availability != null, true);
//		} catch (Exception e) {
//			assertThrows(AvailabilityException.class, () -> {
//				availabilityServices.searchAvailability(availabilityId);
//
//			});
//
//		}
//	}
//
//	@Test
//	void testGetAllAvailability() {
//		List<Availability> availabilityList = availabilityServices.getAllAvailability();
//		assertNotNull(availabilityList);
//	}
//
//	@Test
//	void testDeleteAvailability() {
//		int availabilityId = 44;
//		try {
//			boolean status = availabilityServices.deleteAvailability(availabilityId);
//			assertEquals(status, true);
//		} catch (Exception e) {
//			assertThrows(AvailabilityException.class, () -> {
//				availabilityServices.deleteAvailability(availabilityId);
//
//			});
//		}
//	}
}
