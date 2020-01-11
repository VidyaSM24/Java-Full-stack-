package com.capgemini.mywebapp.servletsforjsp;

import java.io.IOException;
import java.security.Provider.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.beans.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeServices;
import com.capgemini.mywebapp.service.EmployeeServicesImpl;
@WebServlet("/addEmployee2")
public class AddEmployeeServlet extends HttpServlet {
	private EmployeeServices service = new EmployeeServicesImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession(false);
		if(session != null)
		{
			int empId =Integer.parseInt(req.getParameter("empId"));
			String name= req.getParameter("name");
			int age= Integer.parseInt(req.getParameter("age"));
			double salary= Double.parseDouble(req.getParameter("salary"));
			String designation =req.getParameter("designation");
			String password =req.getParameter("password");
			
			EmployeeInfoBean employeeInfoBean = new EmployeeInfoBean();
			employeeInfoBean.setEmp_id(empId);
			employeeInfoBean.setName(name);
			employeeInfoBean.setAge(age);
			employeeInfoBean.setSalary(salary);
			employeeInfoBean.setDesignation(designation);
			employeeInfoBean.setPassword(password);
		boolean isAdded=	service.addEmployee(employeeInfoBean);
		if(isAdded)
		{
			req.setAttribute("msg", "Employee Record Inserted Successfully");
		}else
		{
			req.setAttribute("msg", "Unable to Insert Employee Record");
		}
		req.getRequestDispatcher("./addEmpJspForm.jsp").forward(req, resp);
			
		}else
		{
			req.setAttribute("msg", "Please Login First");
			req.getRequestDispatcher("./LoginForm").forward(req, resp);
		}
	}
	
	

}
