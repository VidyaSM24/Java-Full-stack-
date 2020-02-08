package com.capgemini.bookmydoctor.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.bookmydoctor.dto.Ratings;
import com.capgemini.bookmydoctor.exception.RatingsException;

@SpringBootTest
class RatingsDaoImplTest {
	@Autowired
	RatingsDao ratingsDao;

	@Test
	void testAddRatings() {
		Ratings ratings = new Ratings();

		ratings.setDoctorId(1);
		ratings.setPatientId(1);
		ratings.setRatings("5");
		ratings.setFeedback("Doctor is patients friendly,Well maintained clinic");

		try {
			boolean status = ratingsDao.addRatings(ratings);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(RatingsException.class, () -> {
				ratingsDao.addRatings(ratings);
			});
		}
	}

	@Test
	void testUpdateRatings() {
		Ratings ratings = new Ratings();
		ratings.setFeedback("Not good");
		ratings.setRatings("4");
	}

	@Test
	void testSearchRatings() {
		int ratingsId = 23;
		ratingsDao.searchRatings(ratingsId);
		try {
			Ratings ratings = ratingsDao.searchRatings(ratingsId);
			assertEquals(ratings != null, true);
		} catch (Exception e) {
			assertThrows(RatingsException.class, () -> {
				ratingsDao.searchRatings(ratingsId);

			});

		}
	}

	@Test
	void testGetAllRatings() {
		List<Ratings> ratingsList = ratingsDao.getAllRatings();
		assertNotNull(ratingsList);
	}

	@Test
	void testDeleteRatings() {
		int ratingsId = 24;
		try {
			boolean status = ratingsDao.deleteRatings(ratingsId);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(RatingsException.class, () -> {
				ratingsDao.deleteRatings(ratingsId);

			});
		}
	}
}
