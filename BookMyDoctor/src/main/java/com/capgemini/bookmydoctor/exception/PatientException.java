package com.capgemini.bookmydoctor.exception;

public class PatientException extends RuntimeException {

	String msg;

	public PatientException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;

	}

}
