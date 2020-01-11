package com.capgemini.mywebapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect")
public class Redirectservlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         //String url="http://www.facebook.com";
		
		//Redirect to internal
		//String url1= "http://localhost:8080/mywebapp/date";   //Absolute Path  //External Resource
		String url= "./date";                                   //relative Path  //Internal Resource
		
		resp.sendRedirect(url);

	}//DoGet
}//End of Class
