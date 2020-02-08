package com.capgemini.bookmydoctor.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bookmydoctor.dao.DoctorDao;
import com.capgemini.bookmydoctor.dao.HistoryDao;
import com.capgemini.bookmydoctor.dao.PatientDao;
import com.capgemini.bookmydoctor.dao.UserDao;
import com.capgemini.bookmydoctor.dto.Doctor;
import com.capgemini.bookmydoctor.dto.History;
import com.capgemini.bookmydoctor.dto.Patient;
import com.capgemini.bookmydoctor.dto.User;
import com.capgemini.bookmydoctor.exception.UserException;
import com.capgemini.bookmydoctor.validation.BookMyDoctorValidation;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserDao userDao;

	@Autowired
	private DoctorDao doctorDao;

	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	HistoryDao historyDao;

	@Override
	public boolean addUser(User user) {

		Doctor doctorObject = new Doctor();
		Patient patientObject = new Patient();
		
		String userName = user.getUserName();
		if (BookMyDoctorValidation.isStringOnlyAlphabet(userName)) {
			user.setUserName(userName);
		} else {
			throw new UserException("Enter Only alphabates in User Name Field");
		}
		
		String userType = user.getRole();
		if (BookMyDoctorValidation.isStringOnlyAlphabet(userType)) {
			user.setRole(userType);
		} else {
			throw new UserException("Enter Only alphabates in User Role");
		}
		
		if (userType.equalsIgnoreCase("doctor")) {
			String email = user.getUserEmail();
			doctorObject.setDoctorEmail(email);
			doctorDao.addDoctor(doctorObject);
			
			//Adding To History Table
			History history = new History();
			history.setOperation("User Added As Doctor");
			history.setEventById(doctorObject.getDoctorId());
			history.setEventFor(doctorObject.getDoctorId());
			history.setEventByName(user.getUserName()+", Doctor");
			history.setDateAndTime(BookMyDoctorValidation.dateAndTime());
			historyDao.addHistory(history);


		}
		if (userType.equalsIgnoreCase("patient")) {
			String email = user.getUserEmail();
			patientObject.setPatientEmail(email);
			patientDao.addPatient(patientObject);
			
			//Adding To History Table
			History history = new History();
			history.setOperation("User Added As Patient");
			history.setEventById(patientObject.getPatientId());
			history.setEventFor(patientObject.getPatientId());
			history.setEventByName(user.getUserName()+", Patient");
			history.setDateAndTime(BookMyDoctorValidation.dateAndTime());
			historyDao.addHistory(history);
		}

		return userDao.addUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		String userName = user.getUserName();
		if (BookMyDoctorValidation.isStringOnlyAlphabet(userName)) {
			user.setUserName(userName);
		} else {
			throw new UserException("Enter Only alphabates in User Name Field");
		}
		
		return userDao.updateUser(user);
	}

	@Override
	public User loginUser(User user) {
		return userDao.loginUser(user);
	}

	@Override
	public boolean deleteUser(String userEmail) {
//		User userObject = userDao.searchUser(userId);
//		if (userObject.getRole().equalsIgnoreCase("admin")) {
//			throw new UserException("You Can't Delete The Admin Account");
//		}
//
//		if (userObject.getRole().equalsIgnoreCase("doctor")) {
//			doctorDao.deleteDoctor(userEmail);
//		}
//
//		if (userObject.getRole().equalsIgnoreCase("patient")) {
//			patientDao.deletePatient(userEmail);
//		}

		return userDao.deleteUser(userEmail);
	}

	@Override
	public User searchUser(int userId) {
		return userDao.searchUser(userId);
	}

	@Override
	public ArrayList<User> getAllUser() {
		return userDao.getAllUser();
	}

}
