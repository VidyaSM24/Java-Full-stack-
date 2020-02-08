package com.capgemini.bookmydoctor.service;

import java.util.ArrayList;

import com.capgemini.bookmydoctor.dto.User;

public interface UserServices {
	public boolean addUser(User user);

	public boolean updateUser(User user);

	public User loginUser(User user);

	public boolean deleteUser(String userEmail);

	public User searchUser(int userId);

	public ArrayList<User> getAllUser();

	
}

