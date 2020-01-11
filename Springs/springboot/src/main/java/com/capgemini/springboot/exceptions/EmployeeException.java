package com.capgemini.springboot.exceptions;

public class EmployeeException extends RuntimeException{
	
	public EmployeeException(String messaage) {
		super(messaage);
	}

}
