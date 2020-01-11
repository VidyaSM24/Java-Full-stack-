package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.service.EmployeeServices;
import com.capgemini.mywebapp.service.EmployeeServicesImpl;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
	private EmployeeServices service= new EmployeeServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session =req.getSession(false);
		if(session!=null){
			//valid session
			int empId =Integer.parseInt(req.getParameter("empId"));

			PrintWriter out=resp.getWriter();
			out.println("<html>");
			out.println("<body>");
			if(service.deleteEmployee(empId)) {
				out.println("<h2 style='color: red'>Employee Record for "+empId +"Deleted!</h2>");

			}else {
				out.println("<h2 style='color: red'>Employee Record for "+ empId +"Not Found!</h2>");
			}
			out.println("</body>");
			out.println("</html>");

			req.getRequestDispatcher("./deleteEmpForm.html").include(req, resp);

		}else {
			//invalid session
			PrintWriter out =resp.getWriter();

			out.println("<html>");
			out.println("<body>");
			out.println("<h3 style='color:red'>Please Login First!</h3>");
			out.println("</body>");
			out.println("</html>");

			req.getRequestDispatcher("./loginPageS.html").include(req, resp);


		}

	}
}
