package com.capgemini.bookmydoctor.dao;

import java.util.ArrayList;

import com.capgemini.bookmydoctor.dto.Patient;

public interface PatientDao {
	public boolean addPatient(Patient patient);

	public boolean updatePatient(Patient patient);

	public boolean deletePatient(String patientEmail);

	public Patient searchPatient(int patientId);

	public ArrayList<Patient> getAllPatient();

}

