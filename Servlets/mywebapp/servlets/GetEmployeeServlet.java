package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetEmployeeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Get the Query String
		String idVal = req.getParameter("id");
		ServletContext context=getServletContext();
        String contextParamVal =context.getInitParameter("myContextParam");
		
		resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Employee Id =" +idVal);
		out.println("Name= Vidya");
		out.println("salary= 98446");
		out.println("<br><br>Context Param Value ="+contextParamVal);
		out.println("</body>");
		out.println("</html>");
	}//end of doGet

}//end of class
