package com.capgemini.bookmydoctor.response;

import java.util.List;

import com.capgemini.bookmydoctor.dto.Appointment;

import lombok.Data;

@Data
public class AppointmentResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<Appointment> appointment;

}