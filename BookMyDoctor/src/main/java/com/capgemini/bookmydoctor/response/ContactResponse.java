package com.capgemini.bookmydoctor.response;

import java.util.List;

import com.capgemini.bookmydoctor.dto.Contact;

import lombok.Data;

@Data
public class ContactResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<Contact> Contact;

}