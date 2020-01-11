package com.capgemini.mywebapp.servletsforjsp;

import java.io.IOException;
import java.util.List;

import javax.persistence.metamodel.SetAttribute;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.beans.EmployeeInfoBean;
import com.capgemini.mywebapp.service.EmployeeServices;
import com.capgemini.mywebapp.service.EmployeeServicesImpl;
@WebServlet("/seeAllEmployees")
public class SeeAllEmployeeServlet extends HttpServlet {
	private EmployeeServices service =new EmployeeServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession(false);
		if(session!= null)
		{
             List<EmployeeInfoBean> employeeList =service.getAllEmployees();
             if(employeeList!= null && !employeeList.isEmpty())
             {
            	 req.setAttribute("employeeList", employeeList);
            	
             }else {
            	 req.getRequestDispatcher("./seeAllEmployeeJsp.jsp").forward(req, resp);
            	
             }
		}else
		{
			req.setAttribute("msg", "Please Login First");
			req.getRequestDispatcher("./loginForm").forward(req, resp);
		}
	}

}
