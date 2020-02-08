package com.capgemini.bookmydoctor.service;

import java.util.ArrayList;

import com.capgemini.bookmydoctor.dto.History;

public interface HistoryServices {

public boolean addHistory(History history);
	
	public boolean deleteHistory(int historyId);
	
	public ArrayList<History> getAllHistory();

}
