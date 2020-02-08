package com.capgemini.bookmydoctor.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bookmydoctor.dao.HistoryDao;
import com.capgemini.bookmydoctor.dto.History;

@Service
public class HistoryServicesImpl implements HistoryServices {

	@Autowired
	HistoryDao historyDao;

	@Override
	public boolean addHistory(History history) {
		return historyDao.addHistory(history);
	}

	@Override
	public boolean deleteHistory(int historyId) {
		return historyDao.deleteHistory(historyId);
	}

	@Override
	public ArrayList<History> getAllHistory() {
		return historyDao.getAllHistory();
	}

}
