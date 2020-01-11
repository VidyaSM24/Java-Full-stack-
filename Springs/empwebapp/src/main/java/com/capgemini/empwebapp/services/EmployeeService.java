package com.capgemini.empwebapp.services;

import java.util.List;

import com.capgemini.empwebapp.bean.EmployeeBean;

public interface EmployeeService {
	public EmployeeBean auth(String email,String password);
	public boolean register(EmployeeBean bean);
	public List<EmployeeBean> getEmployees(String key);
	public boolean changePassword(int id,String password);


}
