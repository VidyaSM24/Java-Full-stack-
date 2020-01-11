package com.capgemini.retailermaintenance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.retailermaintenance.dto.ProductBean;
import com.capgemini.retailermaintenance.dto.UserBean;
import com.capgemini.retailermaintenance.dto.UserResponse;
import com.capgemini.retailermaintenance.services.UserServices;
@RestController
public class UserController {
	@Autowired
	private UserServices userServices;
	
	@PostMapping(path="/login",produces=MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse auth(@RequestBody UserBean bean) {
		UserBean userBean=	userServices.userLogin(bean.getUserEmail(),bean.getUserPassword());
		UserResponse response= new UserResponse();
		if(userBean!=null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Employee found For the Credential");
			//response.setUserBean(Arrays.asList(userBean));	
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription(" Credential valid");	
		}
		return response;
	}

	@PostMapping(path="/profile",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public  UserResponse register(@RequestBody UserBean bean) {
		UserResponse response= new UserResponse();
		if(userServices.profile(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Employee Registered");	
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription(" Email already exists");	
		}
		return response;
	}

	@GetMapping(path="/getProducts",produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse getProducts( @RequestParam ("productId" )int productId) {
		UserResponse response= new UserResponse();
		ProductBean productBean =userServices.getProducts(productId);
		if(productBean!=null) {
			
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data Not Found");	
			
		}else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Employee data found");	
		}
		return response;
	}
	@PutMapping(path="/changepassword",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse changePassword(@RequestBody UserBean bean) {
		UserResponse response= new UserResponse();
		if(userServices.changePassword(bean.getUserId(), bean.getUserPassword()) ){
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Password Chnaged");	
	}else {
		response.setStatusCode(401);
		response.setMessage("Failure");
		response.setDescription("password not Chnaged");	
	}
		return response;
	}
}

