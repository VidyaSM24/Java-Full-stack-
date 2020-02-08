package com.capgemini.bookmydoctor.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.bookmydoctor.exception.AppointmentException;
import com.capgemini.bookmydoctor.exception.AvailabilityException;
import com.capgemini.bookmydoctor.exception.DoctorException;
import com.capgemini.bookmydoctor.exception.PatientException;
import com.capgemini.bookmydoctor.exception.RatingsException;
import com.capgemini.bookmydoctor.exception.UserException;
import com.capgemini.bookmydoctor.response.AppointmentResponse;
import com.capgemini.bookmydoctor.response.AvailabilityResponse;
import com.capgemini.bookmydoctor.response.DoctorResponse;
import com.capgemini.bookmydoctor.response.PatientResponse;
import com.capgemini.bookmydoctor.response.RatingsResponse;
import com.capgemini.bookmydoctor.response.UserResponse;

@RestControllerAdvice
public class BookMyDoctorControllerAdvice {

	@ExceptionHandler(UserException.class)
	public UserResponse handleUserException(UserException e) {
		UserResponse userResponse = new UserResponse();
		userResponse.setStatusCode(501);
		userResponse.setMessage("Exception");
		userResponse.setDescription(e.getMessage());
		return userResponse;
	}

	@ExceptionHandler(DoctorException.class)
	public DoctorResponse handleDoctorException(DoctorException e) {
		DoctorResponse doctorResponse = new DoctorResponse();
		doctorResponse.setStatusCode(501);
		doctorResponse.setMessage("Exception");
		doctorResponse.setDescription(e.getMessage());
		return doctorResponse;
	}

	@ExceptionHandler(PatientException.class)
	public PatientResponse handlePatientException(PatientException e) {
		PatientResponse patientResponse = new PatientResponse();
		patientResponse.setStatusCode(501);
		patientResponse.setMessage("Exception");
		patientResponse.setDescription(e.getMessage());
		return patientResponse;
	}

	@ExceptionHandler(RatingsException.class)
	public RatingsResponse handleRatingsException(RatingsException e) {
		RatingsResponse ratingsResponse = new RatingsResponse();
		ratingsResponse.setStatusCode(501);
		ratingsResponse.setMessage("Exception");
		ratingsResponse.setDescription(e.getMessage());
		return ratingsResponse;
	}

	@ExceptionHandler(AppointmentException.class)
	public AppointmentResponse handleAppointmentException(AppointmentException e) {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		appointmentResponse.setStatusCode(501);
		appointmentResponse.setMessage("Exception");
		appointmentResponse.setDescription(e.getMessage());
		return appointmentResponse;
	}

	@ExceptionHandler(AvailabilityException.class)
	public AvailabilityResponse handleAvailabilityException(AvailabilityException e) {
		AvailabilityResponse availabilityResponse = new AvailabilityResponse();
		availabilityResponse.setStatusCode(501);
		availabilityResponse.setMessage("Exception");
		availabilityResponse.setDescription(e.getMessage());
		return availabilityResponse;
	}

}
