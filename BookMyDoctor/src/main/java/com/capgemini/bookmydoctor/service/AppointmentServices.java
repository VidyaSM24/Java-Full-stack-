package com.capgemini.bookmydoctor.service;

import java.util.ArrayList;

import com.capgemini.bookmydoctor.dto.Appointment;

public interface AppointmentServices {

	public boolean addAppointment(Appointment appointment);

	public boolean updateAppointment(Appointment appointment);

	public boolean deleteAppointment(int appointmentId);

	public Appointment searchAppointment(int appointmentId);

	public ArrayList<Appointment> getAllAppointment();
	
	public ArrayList<Appointment> getAllAppointmentDoctor(int doctorId);
	
	public ArrayList<Appointment> getAllAppointmentPatient(int patientId);

}
