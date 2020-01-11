package com.capgemini.mywebapp.service;

import java.util.List;

import com.capgemini.mywebapp.beans.EmployeeInfoBean;
import com.capgemini.mywebapp.dao.EmployeeDao;
import com.capgemini.mywebapp.dao.EmployeeDaoImpl;

public class EmployeeServicesImpl implements EmployeeServices{
	private EmployeeDao dao= new EmployeeDaoImpl();

	@Override
	public EmployeeInfoBean searchEmployee(int empId) {
		
		return dao.searchEmployee(empId);
	}

	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		return dao.authenticate(empId, password);
	}

	@Override
	public boolean deleteEmployee(int empId) {
		
		return dao.deleteEmployee(empId);
	}

	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean) {
		
		return dao.addEmployee(employeeInfoBean);
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		return dao.getAllEmployees();
	}
	
	
	

}
