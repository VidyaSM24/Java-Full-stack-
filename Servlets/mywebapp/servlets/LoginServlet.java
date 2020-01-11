package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.beans.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeServices;
import com.capgemini.mywebapp.service.EmployeeServicesImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet  {
	
	
	private EmployeeServices service = new EmployeeServicesImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Get the form data
		String empIdVal =req.getParameter("empId");
		String password =req.getParameter("password");
		
		int empId= Integer.parseInt(empIdVal);	
		
		EmployeeInfoBean employeeInfoBean=service.authenticate(empId, password);
		
		PrintWriter out =resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		if (employeeInfoBean != null) {
			//validate Credential
			HttpSession session=req.getSession(true);
			session.setAttribute("employeeInfoBean", employeeInfoBean);
			out.println("<h3 style ='color: blue'>Welcome"+ employeeInfoBean.getName()+"!</h3>");
			out.println("<br><a href='./addEmpForm.html'>Add Employee</a>");
			out.println("<br><a href='#'>Update Employee</a>");
			out.println("<br><a href='./searchEmpForm.html'>Search Employee</a>");
			out.println("<br><a href='./deleteEmpForm.html'>Delete Employee</a>");
			out.println("<br><a href='#'>see all Employee</a>");
			out.println("<br><a href='./logout'>LogOut</a>");
			
			
		}else
		{
			//valid credential
			out.println("<h3 style='color:red>Invalid Credentials</h3>");
			req.getRequestDispatcher("./loginPage.html").include(req, resp);
		}
		out.println("</html>");
		out.println("</body>");
		
		
		
		
		
		
	}//End of doPsot
}//Enf of class
