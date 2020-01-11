package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/createCookie")
public class CreateCookieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie myCookie = new Cookie( "empName","Vidya");
		myCookie.setMaxAge(7*24*60*60);
		resp.addCookie(myCookie);
		
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter();
		
		RequestDispatcher dispatcher= req.getRequestDispatcher("./cookiePage.html");
		dispatcher.include(req, resp);
		
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Cookie Created successfully...</h2>");
		out.println("</body>");
		out.println("</html>");

	}





}//End of Class
