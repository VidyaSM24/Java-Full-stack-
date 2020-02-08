package com.capgemini.bookmydoctor.exception;

public class AvailabilityException extends RuntimeException {

	String msg;

	public AvailabilityException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;

	}

}
