package com.capgemini.bookmydoctor.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bookmydoctor.dao.AvailabilityDao;
import com.capgemini.bookmydoctor.dao.HistoryDao;
import com.capgemini.bookmydoctor.dto.Availability;
import com.capgemini.bookmydoctor.dto.History;
import com.capgemini.bookmydoctor.exception.AvailabilityException;
import com.capgemini.bookmydoctor.validation.BookMyDoctorValidation;

@Service
public class AvailabilityServicesImpl implements AvailabilityServices {

	@Autowired
	AvailabilityDao availabilityDao;

	@Autowired
	HistoryDao historyDao;

	@Override
	public boolean addAvailability(Availability availability) {

		String fromDateForValidation = availability.getFromDate();
		String toDateForValidation = availability.getToDate();
		if (fromDateForValidation.equals(toDateForValidation)) {
			throw new AvailabilityException("Please Enter Dates Which Having Minimum One Day Gap");
		}

		String availabilityStatus = availability.getAvailability();
		if (BookMyDoctorValidation.isStringOnlyAlphabet(availabilityStatus)) {
			availability.setAvailability(availabilityStatus);
		} else {
			throw new AvailabilityException("Enter Only alphabates in Availability Status");
		}

		// Adding To History Table
		History history = new History();
		history.setOperation("Doctor Updated Availabilities");
		history.setEventById(availability.getDoctorId());
		history.setEventFor(availability.getDoctorId());
		history.setEventByName(" Doctor");
		history.setDateAndTime(BookMyDoctorValidation.dateAndTime());
		historyDao.addHistory(history);

		return availabilityDao.addAvailability(availability);
	}

	@Override
	public boolean updateAvailability(Availability availability) {
		String availabilityStatus = availability.getAvailability();
		if (BookMyDoctorValidation.isStringOnlyAlphabet(availabilityStatus)) {
			availability.setAvailability(availabilityStatus);
		} else {
			throw new AvailabilityException("Enter Only alphabates Availability Status");
		}

		// Adding To History Table
		History history = new History();
		history.setOperation("Doctor Updated Availabilities");
		history.setEventById(availability.getDoctorId());
		history.setEventFor(availability.getDoctorId());
		history.setEventByName(" Doctor");
		history.setDateAndTime(BookMyDoctorValidation.dateAndTime());
		historyDao.addHistory(history);
		return availabilityDao.updateAvailability(availability);
	}

	@Override
	public boolean deleteAvailability(int availabilityId) {
		return availabilityDao.deleteAvailability(availabilityId);
	}

	@Override
	public Availability searchAvailability(int availabilityId) {
		return availabilityDao.searchAvailability(availabilityId);
	}

	@Override
	public ArrayList<Availability> getAllAvailability() {
		return availabilityDao.getAllAvailability();
	}

}
