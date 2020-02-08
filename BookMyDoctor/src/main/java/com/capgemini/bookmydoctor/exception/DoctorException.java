package com.capgemini.bookmydoctor.exception;

public class DoctorException extends RuntimeException{
	String msg;
	
	public DoctorException(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
	

}
