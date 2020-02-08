 package com.capgemini.bookmydoctor.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.bookmydoctor.dto.User;
import com.capgemini.bookmydoctor.response.UserResponse;
import com.capgemini.bookmydoctor.service.UserServices;


@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class UserController {

	@Autowired
	UserServices userServices;

	@PostMapping(path = "/add-user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse addUser(@RequestBody User user) {
		UserResponse userResponse = new UserResponse();
		if (userServices.addUser(user)) {
			userResponse.setStatusCode(201);
			userResponse.setMessage("Success");
			userResponse.setDescription("User Added Successfully");
		}
		return userResponse;
	}

	@PostMapping(path = "/login-user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse login(@RequestBody User user) {
		UserResponse userResponse = new UserResponse();
		User userAccount = userServices.loginUser(user);
		if (userAccount != null) {
			userResponse.setStatusCode(201);
			userResponse.setDescription("Success");
			userResponse.setMessage("User Logged in Successfully");
			userResponse.setUser(Arrays.asList(userAccount));
		}
		return userResponse;
	}

	@GetMapping(path = "/get-all-user", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse getAllUser() {
		UserResponse userResponse = new UserResponse();
		List<User> userList = userServices.getAllUser();
		if (userList.size() != 0) {
			userResponse.setStatusCode(201);
			userResponse.setMessage("Success");
			userResponse.setDescription("User Found Successfully");
			userResponse.setUser(userList);
			return userResponse;
		}
		return userResponse;
	}

	@PutMapping(path = "/modify-user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse updateUser(@RequestBody User user) {
		UserResponse userResponse = new UserResponse();
		if (userServices.updateUser(user)) {
			userResponse.setStatusCode(201);
			userResponse.setMessage("Success");
			userResponse.setDescription("User Name Modified Successfully");
		}
		return userResponse;
	}

	@DeleteMapping(path = "/delete-user/{userEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse deleteUser(@PathVariable("userEmail") String userEmail) {
		UserResponse userResponse = new UserResponse();
		if (userServices.deleteUser(userEmail)) {
			userResponse.setStatusCode(201);
			userResponse.setMessage("Success");
			userResponse.setDescription("User Deleted Successfully");
		}
		return userResponse;
	}

	@GetMapping(path = "/search-user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse searchUser(@PathVariable("userId") int userId) {
		UserResponse userResponse = new UserResponse();
		User user = userServices.searchUser(userId);
		if (user != null) {
			userResponse.setStatusCode(201);
			userResponse.setMessage("Success");
			userResponse.setDescription("User Found Successfully");
			userResponse.setUser(Arrays.asList(user));
		}
		return userResponse;
	}

}
