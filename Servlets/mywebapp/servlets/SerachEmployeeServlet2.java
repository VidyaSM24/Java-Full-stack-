package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/serachEmployee2")
public class SerachEmployeeServlet2 extends HttpServlet{

	private EmployeeServices service = new EmployeeServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);

		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");

		if(session!=null){
			//valid session
			String empIdVal=req.getParameter("empId");
			int empId =Integer.parseInt(empIdVal);

			EmployeeInfoBean employeeInfoBean=service.searchEmployee(empId);

			if (employeeInfoBean != null) {
				out.println("<h3>EmployeeId " + empId + "Found-</h3>");
				out.println("Name =" + employeeInfoBean.getName());
				out.println("<br>Age =" + employeeInfoBean.getAge());
				out.println("<br>Salary =" + employeeInfoBean.getSalary());
				out.println("<br> Designation =" + employeeInfoBean.getDesignation());
				
			}else {
				out.println("<h3 style ='color: red'> Employee ID " + empId + "Not Found!</h3>");
				
			}
		}else {
			//invalid session
			out.println("please Login first");
			req.getRequestDispatcher("./loginPage.html").include(req, resp);
		}

	}// end of doGet

}//end of class
