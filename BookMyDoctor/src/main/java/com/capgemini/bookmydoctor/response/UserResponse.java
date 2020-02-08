package com.capgemini.bookmydoctor.response;

import java.util.List;

import com.capgemini.bookmydoctor.dto.User;

import lombok.Data;
@Data
public class UserResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<User> user;

	
}
