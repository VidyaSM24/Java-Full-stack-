package com.capgemini.bookmydoctor.exception;

public class HistoryException extends RuntimeException {
	
	String msg;

	public HistoryException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}

}

