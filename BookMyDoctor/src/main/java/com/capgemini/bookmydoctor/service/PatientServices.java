package com.capgemini.bookmydoctor.service;

import java.util.ArrayList;

import com.capgemini.bookmydoctor.dto.Patient;

public interface PatientServices {
	
	public boolean addPatient(Patient patient);

	public boolean updatePatient(Patient patient);

	public boolean deletePatient(String patientEmail);

	public Patient searchPatient(int patientId);

	public ArrayList<Patient> getAllPatient();

}
