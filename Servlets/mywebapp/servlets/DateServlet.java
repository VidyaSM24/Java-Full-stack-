package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Current System Date and Time
		Date date= new Date();

		//Get  The Context Param
		ServletContext context=getServletContext();
		String contextParamVal =context.getInitParameter("myContextParam");

 		//Get Config Param
		ServletConfig config= getServletConfig();
		String configParamVal= config.getInitParameter("myConfigParam");

		resp.setContentType("text/html");
		resp.setHeader("refresh", "1");

		PrintWriter out= resp.getWriter();
		out.print("<h2>Current System Date and Time - <br>"+ date +"</h2>");

		//Displaying Context & config-param value
		out.println("<br><br>Context Param Value =" + contextParamVal);
		out.println("<br><br>Config Param Value =" + configParamVal);
		out.print("</html>");
	}//end of doGet
}//end of class
