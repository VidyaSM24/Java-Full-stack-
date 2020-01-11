package com.capgemini.springboot.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.springboot.dto.EmployeeResponce;
import com.capgemini.springboot.exceptions.EmployeeException;

@RestControllerAdvice
public class EmployeeControllerAdvice {
	
	@ExceptionHandler(EmployeeException.class)
	public EmployeeResponce handleEmployeeResponce(EmployeeException e) {
	EmployeeResponce responce= new EmployeeResponce();
	responce.setStatusCode(501);
	responce.setMessage("Exception");
	responce.setDescription(e.getMessage());
	return responce;
	

}
}
