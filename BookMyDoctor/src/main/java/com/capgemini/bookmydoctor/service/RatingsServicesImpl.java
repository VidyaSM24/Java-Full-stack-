package com.capgemini.bookmydoctor.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bookmydoctor.dao.DoctorDao;
import com.capgemini.bookmydoctor.dao.RatingsDao;
import com.capgemini.bookmydoctor.dto.Doctor;
import com.capgemini.bookmydoctor.dto.Ratings;

@Service
public class RatingsServicesImpl implements RatingsServices {

	@Autowired
	RatingsDao ratingsDao;

	@Autowired
	DoctorDao doctorDao;

	@Override
	public boolean addRatings(Ratings ratings) {
		int doctorId = ratings.getDoctorId();
		String doctorRatingsByPatient = ratings.getRatings();
		double doctorRatByPatient = Double.parseDouble(doctorRatingsByPatient);

		Doctor doctorObject = doctorDao.searchDoctor(doctorId);
		String doctorRatings = doctorObject.getRatings();
		double doctorRatingsInDouble = Double.parseDouble(doctorRatings);
		double finalRatingsInDouble = (doctorRatingsInDouble + doctorRatByPatient) / 2;

		String finalDoctorRatings = Double.toString(finalRatingsInDouble);
		Doctor doctorObjNew = new Doctor();
		doctorObjNew.setRatings(finalDoctorRatings);
		doctorObjNew.setDoctorId(doctorId);
		doctorDao.updateDoctorRatings(doctorObjNew);

		return ratingsDao.addRatings(ratings);
	}

	@Override
	public boolean updateRatings(Ratings ratings) {
		return ratingsDao.updateRatings(ratings);
	}

	@Override
	public boolean deleteRatings(int ratingId) {
		return ratingsDao.deleteRatings(ratingId);
	}

	@Override
	public Ratings searchRatings(int ratingId) {
		return ratingsDao.searchRatings(ratingId);
	}

	@Override
	public ArrayList<Ratings> getAllRatings() {
		return ratingsDao.getAllRatings();
	}

}
