package com.capgemini.bookmydoctor.exception;

public class ContactException extends RuntimeException {

	String msg;

	public ContactException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}

}

