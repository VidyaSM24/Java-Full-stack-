package com.capgemini.mywebapp.servletsforjsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.beans.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeServices;
import com.capgemini.mywebapp.service.EmployeeServicesImpl;
@WebServlet("/login2")
public class LoginServlrtJsp extends HttpServlet {
private EmployeeServices service=new EmployeeServicesImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//To get The Form Data
		int empId =Integer.parseInt(req.getParameter("empId"));
		String password = req.getParameter("password");
		
		EmployeeInfoBean employeeInfoBean=service.authenticate(empId, password);
		if(employeeInfoBean!= null)
		{
			//valid credentials
			HttpSession session= req.getSession(true);
			session.setAttribute("employeeInfoBean", employeeInfoBean);
			session.setMaxInactiveInterval(60);
			
			req.getRequestDispatcher("./homePagejsp.jsp").forward(req, resp);
				
		}else {
			//invalid credential
			req.setAttribute("msg", "invalid credentials");
			req.getRequestDispatcher("./loginForm").forward(req, resp);
		}
	}
}
