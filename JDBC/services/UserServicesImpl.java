package com.capgemini.jdbc.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Properties;

import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.dao.UserDAO;
import com.capgemini.jdbc.factory.UserFactory;


public class UserServicesImpl implements UserServices {
	Properties prop;
	UserDAO dao = UserFactory.instanceOfUserDAOImpl();
	

	@Override
	public List<UserBean> getAllUsers() {
	
		return dao.getAllUsers();
	}

	@Override
	public UserBean userLogin(String username, String password) {
		return dao.userLogin(username, password);
	}

	@Override
	public boolean updateUser(int userid, String password, String email) {
		return dao.updateUser(userid, password, email);
	}

	@Override
	public boolean deleteUser(int userid, String password) {
		return dao.deleteUser(userid, password);
	}

	@Override
	public boolean insertUser(UserBean user) {	
		return dao.insertUser(user);
	}


}
