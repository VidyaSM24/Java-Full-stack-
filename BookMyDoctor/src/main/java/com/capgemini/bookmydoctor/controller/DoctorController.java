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

import com.capgemini.bookmydoctor.dto.Doctor;
import com.capgemini.bookmydoctor.response.DoctorResponse;
import com.capgemini.bookmydoctor.service.DoctorServices;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class DoctorController {

	@Autowired
	DoctorServices doctorServices;

	@PostMapping(path = "/add-doctor", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DoctorResponse addDoctor(@RequestBody Doctor doctor) {
		DoctorResponse doctorResponse = new DoctorResponse();
		if (doctorServices.addDoctor(doctor)) {
			doctorResponse.setStatusCode(201);
			doctorResponse.setMessage("Success");
			doctorResponse.setDescription("Doctor Added Successfully");
		}
		return doctorResponse;
	}

	@GetMapping(path = "/get-all-doctor", produces = MediaType.APPLICATION_JSON_VALUE)
	public DoctorResponse getAllDoctor() {
		DoctorResponse doctorResponse = new DoctorResponse();
		List<Doctor> doctorList = doctorServices.getAllDoctor();
		if (doctorList.size() != 0) {
			doctorResponse.setStatusCode(201);
			doctorResponse.setMessage("Success");
			doctorResponse.setDescription("Doctor Found Successfully");
			doctorResponse.setDoctor(doctorList);
			return doctorResponse;
		}
		return doctorResponse;
	}

	@PutMapping(path = "/modify-doctor", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DoctorResponse updateDoctor(@RequestBody Doctor doctor) {
		DoctorResponse doctorResponse = new DoctorResponse();
		if (doctorServices.updateDoctor(doctor)) {
			doctorResponse.setStatusCode(201);
			doctorResponse.setMessage("Success");
			doctorResponse.setDescription("Doctor Modified Successfully");
		}
		return doctorResponse;
	}

	@DeleteMapping(path = "/delete-doctor/{doctorEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DoctorResponse deleteDoctor(@PathVariable("doctorEmail") String doctorEmail) {
		DoctorResponse doctorResponse = new DoctorResponse();
		if (doctorServices.deleteDoctor(doctorEmail)) {
			doctorResponse.setStatusCode(201);
			doctorResponse.setMessage("Success");
			doctorResponse.setDescription("Doctor Deleted Successfully");
		}
		return doctorResponse;
	}

	@GetMapping(path = "/search-doctor/{doctorId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DoctorResponse searchDoctor(@PathVariable("doctorId") int doctorId) {
		DoctorResponse doctorResponse = new DoctorResponse();
		Doctor doctor = doctorServices.searchDoctor(doctorId);
		if (doctor != null) {
			doctorResponse.setStatusCode(201);
			doctorResponse.setMessage("Success");
			doctorResponse.setDescription("Doctor Found Successfully");
			doctorResponse.setDoctor(Arrays.asList(doctor));
		}
		return doctorResponse;
	}

}
