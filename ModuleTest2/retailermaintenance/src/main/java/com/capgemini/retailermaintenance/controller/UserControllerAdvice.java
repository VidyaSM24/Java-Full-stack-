package com.capgemini.retailermaintenance.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.retailermaintenance.dto.UserResponse;

public class UserControllerAdvice {
	@ExceptionHandler(Exception.class)
	public UserResponse handleEmployeeResponce(Exception e) {
		UserResponse response= new UserResponse();
	response.setStatusCode(404);
	response.setMessage("Exception");
	response.setDescription(e.getMessage());
	return response;
}
}
	