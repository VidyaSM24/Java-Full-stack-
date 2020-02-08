package com.capgemini.bookmydoctor.dao;

import java.util.ArrayList;

import com.capgemini.bookmydoctor.dto.History;

public interface HistoryDao {

public boolean addHistory(History history);
	
	public boolean deleteHistory(int historyId);
	
	public ArrayList<History> getAllHistory();
}
