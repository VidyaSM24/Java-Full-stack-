package com.capgemini.bookmydoctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.bookmydoctor.dto.History;
import com.capgemini.bookmydoctor.response.HistoryResponse;
import com.capgemini.bookmydoctor.service.HistoryServices;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class HistoryController {
	
	@Autowired
	HistoryServices historyServices;
	
	@GetMapping(path = "/get-all-history", produces = MediaType.APPLICATION_JSON_VALUE)
	public HistoryResponse getAllHistory() {
		HistoryResponse historyResponse = new HistoryResponse();
		List<History> historyList = historyServices.getAllHistory();
		if (historyList.size() != 0) {
			historyResponse.setStatusCode(201);
			historyResponse.setMessage("Success");
			historyResponse.setDescription("History Found Successfully");
			historyResponse.setHistory(historyList);
			return historyResponse;
		}
		return historyResponse;
	}
	
	@DeleteMapping(path = "/delete-history/{historyId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public HistoryResponse deleteHistory(@PathVariable("historyId") int historyId) {
		HistoryResponse historyResponse = new HistoryResponse();
		if (historyServices.deleteHistory(historyId)) {
			historyResponse.setStatusCode(201);
			historyResponse.setMessage("Success");
			historyResponse.setDescription("History Deleted Successfully");
		}
		return historyResponse;
	}


}
