package com.capgemini.bookmydoctor.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bookmydoctor.dao.AppointmentDao;
import com.capgemini.bookmydoctor.dao.HistoryDao;
import com.capgemini.bookmydoctor.dto.Appointment;
import com.capgemini.bookmydoctor.dto.History;
import com.capgemini.bookmydoctor.exception.AppointmentException;
import com.capgemini.bookmydoctor.validation.BookMyDoctorValidation;

@Service
public class AppointmentServicesImpl implements AppointmentServices {

	@Autowired
	AppointmentDao appointmentdao;

	@Autowired
	HistoryDao historyDao;

	@Override
	public boolean addAppointment(Appointment appointment) {
		String appointmentStatus = appointment.getAppointmentStatus();
		if (BookMyDoctorValidation.isStringOnlyAlphabet(appointmentStatus)) {
			appointment.getAppointmentStatus();
		} else {
			throw new AppointmentException("Enter Only alphabates in Appointment status");
		}

		// Adding To History Table
		History history = new History();
		history.setOperation("Patient ask for Appointment");
		history.setEventById(appointment.getPatientId());
		history.setEventFor(appointment.getDoctorId());
		history.setEventByName("Patient");
		history.setDateAndTime(BookMyDoctorValidation.dateAndTime());
		historyDao.addHistory(history);
		return appointmentdao.addAppointment(appointment);
	}

	@Override
	public boolean updateAppointment(Appointment appointment) {
		String appointmentStatus = appointment.getAppointmentStatus();
		if (BookMyDoctorValidation.isStringOnlyAlphabet(appointmentStatus)) {
			appointment.getAppointmentStatus();
		} else {
			throw new AppointmentException("Enter Only alphabates in Appointment Status");
		}
		
		if (appointment.getAppointmentStatus().equalsIgnoreCase("approved")) {
			History history = new History();
			history.setOperation("Doctor Approved Appointment");
			history.setEventById(appointment.getDoctorId());
			history.setEventFor(appointment.getPatientId());
			history.setEventByName("Doctor");
			history.setDateAndTime(BookMyDoctorValidation.dateAndTime());
			historyDao.addHistory(history);
		}
		
		return appointmentdao.updateAppointment(appointment);
	}

	@Override
	public boolean deleteAppointment(int appointmentId) {
		return appointmentdao.deleteAppointment(appointmentId);
	}

	@Override
	public Appointment searchAppointment(int appointmentId) {
		return appointmentdao.searchAppointment(appointmentId);
	}

	@Override
	public ArrayList<Appointment> getAllAppointment() {
		return appointmentdao.getAllAppointment();
	}

	@Override
	public ArrayList<Appointment> getAllAppointmentDoctor(int doctorId) {
		return appointmentdao.getAllAppointmentDoctor(doctorId);
	}

	@Override
	public ArrayList<Appointment> getAllAppointmentPatient(int patientId) {
		return appointmentdao.getAllAppointmentPatient(patientId);
	}

}
