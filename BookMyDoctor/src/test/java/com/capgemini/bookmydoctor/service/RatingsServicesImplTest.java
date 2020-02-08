package com.capgemini.bookmydoctor.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.bookmydoctor.dto.Ratings;
import com.capgemini.bookmydoctor.exception.RatingsException;
@SpringBootTest
class RatingsServicesImplTest {

	@Autowired
	RatingsServices ratingsServices;

	@Test
	void testAddRatings() {
		Ratings ratings = new Ratings();

		ratings.setDoctorId(45);
		ratings.setPatientId(5);
		ratings.setRatings("3");
		ratings.setFeedback("Doctor is patients friendly,Well maintained clinic");

		try {
			boolean status = ratingsServices.addRatings(ratings);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(RatingsException.class, () -> {
				ratingsServices.addRatings(ratings);
			});
		}
	}

	@Test
	void testUpdateRatings() {
		Ratings ratings = new Ratings();
		ratings.setFeedback(" good");
		ratings.setRatings("5");
	}

	@Test
	void testSearchRatings() {
		int ratingsId = 53;
		ratingsServices.searchRatings(ratingsId);
		try {
			Ratings ratings = ratingsServices.searchRatings(ratingsId);
			assertEquals(ratings != null, true);
		} catch (Exception e) {
			assertThrows(RatingsException.class, () -> {
				ratingsServices.searchRatings(ratingsId);

			});

		}
	}

	@Test
	void testGetAllRatings() {
		List<Ratings> ratingsList = ratingsServices.getAllRatings();
		assertNotNull(ratingsList);
	}

	@Test
	void testDeleteRatings() {
		int ratingsId = 48;
		try {
			boolean status = ratingsServices.deleteRatings(ratingsId);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(RatingsException.class, () -> {
				ratingsServices.deleteRatings(ratingsId);

			});
		}
	}
}

