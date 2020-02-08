package com.capgemini.bookmydoctor.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bookmydoctor.dao.DoctorDao;
import com.capgemini.bookmydoctor.dao.HistoryDao;
import com.capgemini.bookmydoctor.dto.Doctor;
import com.capgemini.bookmydoctor.dto.History;
import com.capgemini.bookmydoctor.exception.DoctorException;
import com.capgemini.bookmydoctor.validation.BookMyDoctorValidation;

@Service
public class DoctorServicesImpl implements DoctorServices {

	@Autowired
	DoctorDao doctorDao;
	
	@Autowired
	HistoryDao historyDao;

	@Override
	public boolean addDoctor(Doctor doctor) {

		String firstName = doctor.getFirstName();
		if (BookMyDoctorValidation.isStringOnlyAlphabet(firstName)) {
			doctor.setFirstName(firstName);
		} else {
			throw new DoctorException("Enter Only alphabates in Doctor First Name Field");
		}

		String lastName = doctor.getLastName();
		if (BookMyDoctorValidation.isStringOnlyAlphabet(lastName)) {
			doctor.setLastName(lastName);
		} else {
			throw new DoctorException("Enter Only alphabates in Doctor Last Name Field");
		}

		
		//Adding To History Table
		History history = new History();
		history.setOperation("Doctor Added Details");
		history.setEventById(doctor.getDoctorId());
		history.setEventFor(doctor.getDoctorId());
		history.setEventByName(doctor.getFirstName()+", Doctor");
		history.setDateAndTime(BookMyDoctorValidation.dateAndTime());
		historyDao.addHistory(history);

		return doctorDao.addDoctor(doctor);
	}

	@Override
	public boolean updateDoctor(Doctor doctor) {
		
		String firstName = doctor.getFirstName();
		if (BookMyDoctorValidation.isStringOnlyAlphabet(firstName)) {
			doctor.setFirstName(firstName);
		} else {
			throw new DoctorException("Enter Only alphabates in Doctor First Name Field");
		}

		String lastName = doctor.getLastName();
		if (BookMyDoctorValidation.isStringOnlyAlphabet(lastName)) {
			doctor.setLastName(lastName);
		} else {
			throw new DoctorException("Enter Only alphabates in Doctor Last Name Field");
		}

		String specialization = doctor.getSpecialization();
		if (BookMyDoctorValidation.isStringOnlyAlphabet(specialization)) {
			doctor.setSpecialization(specialization);
		} else {
			throw new DoctorException("Enter Only alphabates in Doctor Specialization Field");
		}

		String clinic = doctor.getClinicName();
		if (BookMyDoctorValidation.isStringOnlyAlphabet(clinic)) {
			doctor.setClinicName(clinic);
		} else {
			throw new DoctorException("Enter Only alphabates in Doctor Clinic Field");
		}
		
		return doctorDao.updateDoctor(doctor);
	}

	@Override
	public Doctor searchDoctor(int doctorId) {
		return doctorDao.searchDoctor(doctorId);
	}

	@Override
	public ArrayList<Doctor> getAllDoctor() {
		return doctorDao.getAllDoctor();
	}

	@Override
	public boolean deleteDoctor(String doctorEmail) {
		return doctorDao.deleteDoctor(doctorEmail);
	}

	@Override
	public boolean updateDoctorRatings(Doctor doctor) {
		return doctorDao.updateDoctorRatings(doctor);
	}

}
