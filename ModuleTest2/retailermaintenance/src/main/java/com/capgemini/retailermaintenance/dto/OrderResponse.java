package com.capgemini.retailermaintenance.dto;

import lombok.Data;

@Data
public class OrderResponse {
	private int statusCode;
	private String message;
	private String description;

}
