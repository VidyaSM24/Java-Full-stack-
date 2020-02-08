
package com.capgemini.bookmydoctor.response;

import java.util.List;

import com.capgemini.bookmydoctor.dto.Doctor;

import lombok.Data;

@Data
public class DoctorResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<Doctor> doctor;
}