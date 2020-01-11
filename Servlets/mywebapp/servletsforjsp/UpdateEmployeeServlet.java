package com.capgemini.mywebapp.servletsforjsp;

import java.io.IOException;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.beans.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeServices;
import com.capgemini.mywebapp.service.EmployeeServicesImpl;
@WebServlet("/updateEmployee2")
public class UpdateEmployeeServlet extends HttpServlet{
	private EmployeeServices service = new EmployeeServicesImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession(false);
		if(session != null)
		{
			int empId =Integer.parseInt(req.getParameter("empId"));
			String name= req.getParameter("name");
			String ageVal= req.getParameter("age");
			String salaryVal= req.getParameter("salary");
			String designation =req.getParameter("designation");
			String password =req.getParameter("password");
			
			
			
			EmployeeInfoBean employeeInfoBean = new EmployeeInfoBean();
			employeeInfoBean.setEmp_id(empId);
			employeeInfoBean.setName(name);
			
			if(ageVal!= null && !ageVal.isEmpty()) {
				int age= Integer.parseInt(ageVal);
				employeeInfoBean.setAge(age);
			}
			
			if(salaryVal!= null && !salaryVal.isEmpty()) {
				int salary= Integer.parseInt(salaryVal);
				employeeInfoBean.setSalary(salary);
			}
			employeeInfoBean.setDesignation(designation);
			employeeInfoBean.setPassword(password);
		   boolean isUpdated=service.updateEmployee(employeeInfoBean);
		   if(isUpdated)
			{
				req.setAttribute("msg", "Employee Details Updated Successfully");
			}else
			{
				req.setAttribute("msg", "Please Try Again");
			}
			req.getRequestDispatcher("./updateEmpJspForm.jsp").forward(req, resp);
		
			
		}else
		{
			req.setAttribute("msg", "Please Login First");
			req.getRequestDispatcher("./loginForm").forward(req, resp);
		}
	}
	}
	
	


