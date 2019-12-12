package com.capgemini.jdbc.dao;

import java.util.List;

import com.capgemini.jdbc.bean.UserBean;

public interface UserDAO {
	public List<UserBean> getAllUsers();
	public UserBean userLogin(String username,String password);
	public boolean updateUser( int userid,String password,String email);
	public boolean deleteUser(int userid,String password);
	public boolean insertUser(UserBean user);
	//boolean updateUser(int userid, String password, String email);
	
	

}
