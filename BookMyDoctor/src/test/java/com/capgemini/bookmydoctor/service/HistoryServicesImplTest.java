package com.capgemini.bookmydoctor.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.capgemini.bookmydoctor.dto.History;
import com.capgemini.bookmydoctor.exception.HistoryException;
@SpringBootTest
class HistoryServicesImplTest {

	@Autowired
	HistoryServices historyservices;

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
			boolean status = historyservices.addHistory(history);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(HistoryException.class, () -> {
				historyservices.addHistory(history);
			});
		}
	}

	@Test
	void testDeleteHistory() {
		int historyId =1;
		try {
			boolean status = historyservices.deleteHistory(historyId);
			assertEquals(status, true);
		} catch (Exception e) {
			assertThrows(HistoryException.class, () -> {
				historyservices.deleteHistory(historyId);
				

			});
		}
	}

	@Test
	void testGetAllHistory() {
		List<History> histotyList = historyservices.getAllHistory();
		assertNotNull(histotyList);

	}

}

