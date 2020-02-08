package com.capgemini.bookmydoctor.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bookmydoctor.dao.PatientDao;
import com.capgemini.bookmydoctor.dto.Patient;
import com.capgemini.bookmydoctor.exception.PatientException;
import com.capgemini.bookmydoctor.validation.BookMyDoctorValidation;

@Service
public class PatientServicesImpl implements PatientServices {

	@Autowired
	PatientDao patientdao;

	@Override
	public boolean addPatient(Patient patient) {
		String firstName = patient.getPatientFirstName();
		if (BookMyDoctorValidation.isStringOnlyAlphabet(firstName)) {
			patient.setPatientFirstName(firstName);
		} else {
			throw new PatientException("Enter Only alphabates in Patient First Name Field");
		}

		String lastName = patient.getPatientLastName();
		if (BookMyDoctorValidation.isStringOnlyAlphabet(lastName)) {
			patient.setPatientLastName(lastName);
		} else {
			throw new PatientException("Enter Only alphabates in Patient Last Name Field");
		}

		String gender = patient.getGender();
		if (BookMyDoctorValidation.isStringOnlyAlphabet(gender)) {
			patient.setGender(gender);
		} else {
			throw new PatientException("Enter Only alphabates in Patient Gender Field");
		}

		return patientdao.addPatient(patient);
	}

	@Override
	public boolean updatePatient(Patient patient) {
		String firstName = patient.getPatientFirstName();
		if (BookMyDoctorValidation.isStringOnlyAlphabet(firstName)) {
			patient.setPatientFirstName(firstName);
		} else {
			throw new PatientException("Enter Only alphabates in Patient First Name Field");
		}

		String lastName = patient.getPatientLastName();
		if (BookMyDoctorValidation.isStringOnlyAlphabet(lastName)) {
			patient.setPatientLastName(lastName);
		} else {
			throw new PatientException("Enter Only alphabates in Patient Last Name Field");
		}

		String gender = patient.getGender();
		if (BookMyDoctorValidation.isStringOnlyAlphabet(gender)) {
			patient.setGender(gender);
		} else {
			throw new PatientException("Enter Only alphabates in Patient Gender Field");
		}

		return patientdao.updatePatient(patient);
	}

	@Override
	public boolean deletePatient(String patientEmail) {
		return patientdao.deletePatient(patientEmail);
	}

	@Override
	public Patient searchPatient(int patientId) {
		return patientdao.searchPatient(patientId);
	}

	@Override
	public ArrayList<Patient> getAllPatient() {
		return patientdao.getAllPatient();
	}

}