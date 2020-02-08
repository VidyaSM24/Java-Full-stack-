package com.capgemini.bookmydoctor.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.bookmydoctor.dto.History;
import com.capgemini.bookmydoctor.exception.HistoryException;

@SpringBootTest
class HistoryDaoImplTest {

	@Autowired
	HistoryDao historyDao;

	@Test
	void testAddHistory() {
		History history = new History();

		history.setEventById(1);
		//history.setHistoryId(1);
		history.setEventByName("doctor");
		history.setEventFor(1);
		history.setOperation("login");
		history.setDateAndTime("24/02/2020");

		try {
			boolean status = historyDao.addHistory(history);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(HistoryException.class, () -> {
				historyDao.addHistory(history);
			});
		}
	}

	@Test
	void testDeleteHistory() {
		int historyId =1;
		try {
			boolean status = historyDao.deleteHistory(historyId);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(HistoryException.class, () -> {
				historyDao.deleteHistory(historyId);
				

			});
		}
	}

	@Test
	void testGetAllHistory() {
		List<History> histotyList = historyDao.getAllHistory();
		assertNotNull(histotyList);

	}

}
