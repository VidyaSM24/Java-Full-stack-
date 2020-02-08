package com.capgemini.bookmydoctor.response;

import java.util.List;

import com.capgemini.bookmydoctor.dto.Availability;

import lombok.Data;

@Data
public class AvailabilityResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<Availability> availability;

}
