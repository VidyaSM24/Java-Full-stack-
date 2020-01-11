package com.capgemini.mywebapp.servletsforjsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.capgemini.mywebapp.beans.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeServices;
import com.capgemini.mywebapp.service.EmployeeServicesImpl;
@WebServlet("/delete")
public class DeleteEmployeeServlet extends HttpServlet {
	private EmployeeServices service= new EmployeeServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			//validate
			int empId=Integer.parseInt(req.getParameter("empId"));
			boolean isDeleted=service.deleteEmployee(empId);
			if(isDeleted)
			{
				req.setAttribute("msg", "Record For employee Id "+ empId + "Deleted!");
			}else {
				req.setAttribute("msg", " Employee Id "+ empId + "Not Found!");
			}
			
			req.getRequestDispatcher("./deleteEmpFormJsp.jsp").forward(req, resp);
		}else
		{
			req.setAttribute("msg", "please Login First" );
			req.getRequestDispatcher("./loginForm").forward(req, resp);
		}

	}
}

