package com.capgemini.bookmydoctor.response;

import java.util.List;

import com.capgemini.bookmydoctor.dto.History;

import lombok.Data;
@Data
public class HistoryResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<History> history;
	
	
	
	
}
