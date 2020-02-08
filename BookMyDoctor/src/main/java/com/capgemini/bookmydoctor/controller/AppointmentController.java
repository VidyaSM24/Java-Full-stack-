package com.capgemini.bookmydoctor.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.bookmydoctor.dto.Appointment;
import com.capgemini.bookmydoctor.response.AppointmentResponse;
import com.capgemini.bookmydoctor.service.AppointmentServices;


@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class AppointmentController {

	@Autowired
	AppointmentServices appointmentServices;

	@PostMapping(path = "/add-appointment", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse addAppointments(@RequestBody Appointment appointment) {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		if (appointmentServices.addAppointment(appointment)) {
			appointmentResponse.setStatusCode(201);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDescription("Appointment Added Successfully");
		}
		return appointmentResponse;
	}

	@GetMapping(path = "/get-all-appointment", produces = MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse getAllAppointment() {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		List<Appointment> appointmentList = appointmentServices.getAllAppointment();
		if (appointmentList.size() != 0) {
			appointmentResponse.setStatusCode(201);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDescription("Appointment Found Successfully");
			appointmentResponse.setAppointment(appointmentList);
			return appointmentResponse;
		}
		return appointmentResponse;
	}
	
	@GetMapping(path = "/get-all-appointment-doctor/{doctorId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse getAllAppointmentDoctor(@PathVariable("doctorId") int doctorId) {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		List<Appointment> appointmentList = appointmentServices.getAllAppointmentDoctor(doctorId);
		if (appointmentList.size() != 0) {
			appointmentResponse.setStatusCode(201);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDescription("Appointment Found Successfully");
			appointmentResponse.setAppointment(appointmentList);
			return appointmentResponse;
		}
		return appointmentResponse;
	}
	
	@GetMapping(path = "/get-all-appointment-patient/{patientId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse getAllAppointmentPatient(@PathVariable("patientId") int patientId) {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		List<Appointment> appointmentList = appointmentServices.getAllAppointmentPatient(patientId);
		if (appointmentList.size() != 0) {
			appointmentResponse.setStatusCode(201);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDescription("Appointment Found Successfully");
			appointmentResponse.setAppointment(appointmentList);
			return appointmentResponse;
		}
		return appointmentResponse;
	}
	

	@PutMapping(path = "/modify-appointment", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse updateAppointment(@RequestBody Appointment appointment) {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		if (appointmentServices.updateAppointment(appointment)) {
			appointmentResponse.setStatusCode(201);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDescription("Appointments Modified Successfully");
		}
		return appointmentResponse;
	}

	@DeleteMapping(path = "/delete-appointment/{appointmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse deleteAppointments(@PathVariable("appointmentId") int appointmentId) {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		if (appointmentServices.deleteAppointment(appointmentId)) {
			appointmentResponse.setStatusCode(201);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDescription("Appointment Deleted Successfully");
		}
		return appointmentResponse;
	}

	@GetMapping(path = "/search-appointment/{appointmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse searchAppointments(@PathVariable("appointmentId") int appointmentId) {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		Appointment appointment = appointmentServices.searchAppointment(appointmentId);
		if (appointment != null) {
			appointmentResponse.setStatusCode(201);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDescription("Appointment Found Successfully");
			appointmentResponse.setAppointment(Arrays.asList(appointment));
		}
		return appointmentResponse;
	}

}
