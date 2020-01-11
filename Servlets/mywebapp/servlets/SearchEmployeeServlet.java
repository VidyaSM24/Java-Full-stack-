package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.mywebapp.beans.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeServices;
import com.capgemini.mywebapp.service.EmployeeServicesImpl;
@WebServlet("/searchEmployee3")
public class SearchEmployeeServlet extends HttpServlet {
	
	private EmployeeServices employeeService =new EmployeeServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Get The Form
		String empIdVal= req.getParameter("empId");
		int empId =Integer.parseInt(empIdVal);
		EmployeeInfoBean employeeInfoBean=employeeService.searchEmployee(empId);
		
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter();
		out.println("<html>");
		out.println("<body>");		
		
		if (employeeInfoBean != null) {
			out.println("<h3>EmployeeId "+empId + "Found-</h3>");
			out.println("Name =" + employeeInfoBean.getName());
			out.println("<br>Age =" + employeeInfoBean.getAge());
			out.println("<br>Salary =" + employeeInfoBean.getSalary());
			out.println("<br> Designation =" + employeeInfoBean.getDesignation());
			
		}else {
			out.println("<h3 style ='color: red'> Employee ID " + empId +"Not Found!</h3>");
			
		}
		out.println("</html>");
		out.println("</body>");		
		
		
	}

}
