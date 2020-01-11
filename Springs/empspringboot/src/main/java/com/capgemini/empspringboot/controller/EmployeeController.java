package com.capgemini.empspringboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.empspringboot.dto.EmployeeBean;
import com.capgemini.empspringboot.dto.EmployeeResponce;
import com.capgemini.empspringboot.services.EmployeeService;
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping(path="/auth",produces=MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponce auth(@RequestBody EmployeeBean bean) {
		EmployeeBean employeeBean=	service.auth(bean.getEmail(),bean.getPassword());
		EmployeeResponce responce= new EmployeeResponce();
		if(employeeBean!=null) {
			responce.setStatusCode(201);
			responce.setMessage("success");
			responce.setDescription("Employee found For the Credential");
			responce.setBeans(Arrays.asList(employeeBean));	
		}else {
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription(" Credential valid");	
		}
		return responce;
	}
	
	
	
	@PostMapping(path="/register",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public  EmployeeResponce register(@RequestBody EmployeeBean bean) {
		EmployeeResponce responce= new EmployeeResponce();
		if(service.register(bean)) {
			responce.setStatusCode(201);
			responce.setMessage("success");
			responce.setDescription("Employee Registered");	
		}else {
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription(" Email already exists");	
		}
		return responce;
	}
	@GetMapping(path="/get",produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponce searchEmployee( @RequestParam ("key" )String key) {
		EmployeeResponce responce= new EmployeeResponce();
		List<EmployeeBean> beans =service.getEmployees(key);
		if(beans.isEmpty()) {
			
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription("Data Not Found");	
			
		}else {
			responce.setStatusCode(201);
			responce.setMessage("success");
			responce.setDescription("Employee data found");	
		}
		return responce;
	}
	@PutMapping(path="/changepassword",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponce changePassword(@RequestBody EmployeeBean bean) {
		EmployeeResponce responce= new EmployeeResponce();
		if(service.changePassword(bean.getId(), bean.getPassword())) {
			responce.setStatusCode(201);
			responce.setMessage("success");
			responce.setDescription("Password Chnaged");	
	}else {
		responce.setStatusCode(401);
		responce.setMessage("Failure");
		responce.setDescription("password not Chnaged");	
	}
		return responce;
	}
	@DeleteMapping(path="/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponce deleteEmployee(@PathVariable("id") int id) {
		EmployeeResponce responce= new EmployeeResponce();
		
		service.deleteEmployee(id) ;
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("Employee Details deleted");
			
			
			return responce;
		}
		
	}


