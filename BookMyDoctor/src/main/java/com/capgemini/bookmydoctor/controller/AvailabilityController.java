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

import com.capgemini.bookmydoctor.dto.Availability;
import com.capgemini.bookmydoctor.response.AvailabilityResponse;
import com.capgemini.bookmydoctor.service.AvailabilityServices;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class AvailabilityController {

	@Autowired
	AvailabilityServices availabilityServices;

	@PostMapping(path = "/add-availability", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AvailabilityResponse addAvailability(@RequestBody Availability availability) {
		AvailabilityResponse availabilityResponse = new AvailabilityResponse();
		if (availabilityServices.addAvailability(availability)) {
			availabilityResponse.setStatusCode(201);
			availabilityResponse.setMessage("Success");
			availabilityResponse.setDescription("Availability Added Successfully");
		}
		return availabilityResponse;
	}

	@GetMapping(path = "/get-all-availability", produces = MediaType.APPLICATION_JSON_VALUE)
	public AvailabilityResponse getAllAvailability() {
		AvailabilityResponse availabilityResponse = new AvailabilityResponse();
		List<Availability> availabilityList = availabilityServices.getAllAvailability();
		if (availabilityList.size() != 0) {
			availabilityResponse.setStatusCode(201);
			availabilityResponse.setMessage("Success");
			availabilityResponse.setDescription("Availability Found Successfully");
			availabilityResponse.setAvailability(availabilityList);
			return availabilityResponse;
		}
		return availabilityResponse;
	}

	@PutMapping(path = "/modify-availability", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AvailabilityResponse updateAvailability(@RequestBody Availability availability) {
		AvailabilityResponse availabilityResponse = new AvailabilityResponse();
		if (availabilityServices.updateAvailability(availability)) {
			availabilityResponse.setStatusCode(201);
			availabilityResponse.setMessage("Success");
			availabilityResponse.setDescription("Availability Modified Successfully");
		}
		return availabilityResponse;
	}

	@DeleteMapping(path = "/delete-availability/{availabilityId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AvailabilityResponse deleteAvailability(@PathVariable("availabilityId") int availabilityId) {
		AvailabilityResponse availabilityResponse = new AvailabilityResponse();
		if (availabilityServices.deleteAvailability(availabilityId)) {
			availabilityResponse.setStatusCode(201);
			availabilityResponse.setMessage("Success");
			availabilityResponse.setDescription("Availability Deleted Successfully");
		}
		return availabilityResponse;
	}

	@GetMapping(path = "/search-availability/{availabilityId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AvailabilityResponse searchAvailability(@PathVariable("availabilityId") int availabilityId) {
		AvailabilityResponse availabilityResponse = new AvailabilityResponse();
		Availability availability = availabilityServices.searchAvailability(availabilityId);
		if (availability != null) {
			availabilityResponse.setStatusCode(201);
			availabilityResponse.setMessage("Success");
			availabilityResponse.setDescription("Availability Found Successfully");
			availabilityResponse.setAvailability(Arrays.asList(availability));
		}
		return availabilityResponse;
	}

}
