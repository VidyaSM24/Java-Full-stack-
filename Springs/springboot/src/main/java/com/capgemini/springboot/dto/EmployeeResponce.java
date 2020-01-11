package com.capgemini.springboot.dto;

import java.util.List;

import lombok.Data;

@Data
public class EmployeeResponce {
	private int statusCode;
	private String message;
	private String description;
	private List<EmployeeBean> beans;

}
