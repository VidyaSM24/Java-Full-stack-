package com.capgemini.bookmydoctor.exception;

public class RatingsException extends RuntimeException {

	String msg;
	
	public RatingsException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;

	}

}
