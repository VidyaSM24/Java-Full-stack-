package com.capgemini.bookmydoctor.dao;

import java.util.ArrayList;

import com.capgemini.bookmydoctor.dto.User;

public interface UserDao {

	public boolean addUser(User user);

	public boolean updateUser(User user);

	public User loginUser(User user);

	public boolean deleteUser(String userEmail);

	public User searchUser(int userId);

	public ArrayList<User> getAllUser();
}
