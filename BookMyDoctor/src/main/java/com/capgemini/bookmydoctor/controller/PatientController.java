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

import com.capgemini.bookmydoctor.dto.Patient;
import com.capgemini.bookmydoctor.response.PatientResponse;
import com.capgemini.bookmydoctor.service.PatientServices;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class PatientController {

	@Autowired
	PatientServices patientServices;

	@PostMapping(path = "/add-patient", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PatientResponse addPatient(@RequestBody Patient patient) {
		PatientResponse patientResponse = new PatientResponse();
		if (patientServices.addPatient(patient)) {
			patientResponse.setStatusCode(201);
			patientResponse.setMessage("Success");
			patientResponse.setDescription("Patient Added Successfully");
		}
		return patientResponse;
	}

	@GetMapping(path = "/get-all-patient", produces = MediaType.APPLICATION_JSON_VALUE)
	public PatientResponse getAllPatient() {
		PatientResponse patientResponse = new PatientResponse();
		List<Patient> patientList = patientServices.getAllPatient();
		if (patientList.size() != 0) {
			patientResponse.setStatusCode(201);
			patientResponse.setMessage("Success");
			patientResponse.setDescription("Patient Found Successfully");
			patientResponse.setPatient(patientList);
			return patientResponse;
		}
		return patientResponse;
	}

	@PutMapping(path = "/modify-patient", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PatientResponse updatePatient(@RequestBody Patient patient) {
		PatientResponse patientResponse = new PatientResponse();
		if (patientServices.updatePatient(patient)) {
			patientResponse.setStatusCode(201);
			patientResponse.setMessage("Success");
			patientResponse.setDescription("Patient Modified Successfully");
		}
		return patientResponse;
	}

	@DeleteMapping(path = "/delete-patient/{patientEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PatientResponse deletePatient(@PathVariable("patientEmail") String patientEmail) {
		PatientResponse patientResponse = new PatientResponse();
		if (patientServices.deletePatient(patientEmail)) {
			patientResponse.setStatusCode(201);
			patientResponse.setMessage("Success");
			patientResponse.setDescription("Patient Deleted Successfully");
		}
		return patientResponse;
	}

	@GetMapping(path = "/search-patient/{patientId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PatientResponse searchPatient(@PathVariable("patientId") int patientId) {
		PatientResponse patientResponse = new PatientResponse();
		Patient patient = patientServices.searchPatient(patientId);
		if (patient != null) {
			patientResponse.setStatusCode(201);
			patientResponse.setMessage("Success");
			patientResponse.setDescription("Patient Found Successfully");
			patientResponse.setPatient(Arrays.asList(patient));
		}
		return patientResponse;
	}

}
