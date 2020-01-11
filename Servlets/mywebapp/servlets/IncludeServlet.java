package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/include")
public class IncludeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url="./date";
		
		
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Hello User</h2><br>");
		
		
		RequestDispatcher dispatcher=req.getRequestDispatcher(url);
		dispatcher.include(req, resp);
		
		out.println("<h2>Thank You</h2><br>");
		out.println("</body>");
		out.println("</html>");
		
		

	

	}

}
