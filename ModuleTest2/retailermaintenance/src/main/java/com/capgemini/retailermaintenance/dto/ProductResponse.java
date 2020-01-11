package com.capgemini.retailermaintenance.dto;

import lombok.Data;

@Data
public class ProductResponse {
	private int statusCode;
	private String message;
	private String description;

}
