package com.capgemini.mywebapp.servletsforjsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.beans.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeServices;
import com.capgemini.mywebapp.service.EmployeeServicesImpl;

public class GetEmployeeServlet extends HttpServlet {
	private EmployeeServices service= new EmployeeServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession(false);
		if(session!=null)
		{
			//valid Session
			//get the form data
			
			int empId=Integer.parseInt(req.getParameter("empId"));
		EmployeeInfoBean employeeInfoBean=service.searchEmployee(empId);
			req.setAttribute("EmployeeInfoBean", employeeInfoBean);
			req.getRequestDispatcher("./SearchEmpJspForm.jsp").forward(req, resp);
			
		}else
		{
			//invalid session
			req.setAttribute("msg", "please Login First" );
			req.getRequestDispatcher("./loginForm").forward(req, resp);
			
		}
	}
	
	

}// End of class
