package com.capgemini.mywebapp.dao;

import java.util.List;

import com.capgemini.mywebapp.beans.EmployeeInfoBean;

public interface EmployeeDao {
	
	public EmployeeInfoBean authenticate(int empId,String password);
	public EmployeeInfoBean searchEmployee(int empId);
	
	public boolean deleteEmployee(int empId);
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean);
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean);
	public List<EmployeeInfoBean> getAllEmployees();
	

}
