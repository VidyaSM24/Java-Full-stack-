package com.capgemini.bookmydoctor.exception;

public class AppointmentException extends RuntimeException {

	String msg;

	public AppointmentException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;

	}

}
