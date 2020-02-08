package com.capgemini.bookmydoctor.dao;

import java.util.ArrayList;

import com.capgemini.bookmydoctor.dto.Doctor;

public interface DoctorDao {
	public boolean addDoctor(Doctor doctor);

	public boolean updateDoctor(Doctor doctor);

	public boolean deleteDoctor(String doctorEmail);

	public Doctor searchDoctor(int doctorId);

	public ArrayList<Doctor> getAllDoctor();
	
	public boolean updateDoctorRatings(Doctor doctor);
}