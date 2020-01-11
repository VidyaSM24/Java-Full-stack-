<%@page import="com.capgemini.empwebapp.bean.EmployeeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<<jsp:useBean id="bean"
	class="com.capgemini.empwebapp.bean.EmployeeBean" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="./changepassword"> Change Password</a>
	<a href="./logout" style="float: right;">Logout</a>

	<h1>
		Welcome
		<%=bean.getName()%></h1>
	<form action="./search" >
		<table>
			<tr>
				<td>Enter Key:</td>
				<td><input type="text" name="key"></td>
				<td><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form>
	
	<%
	List<EmployeeBean> list=(List<EmployeeBean>)request.getAttribute("list");

	%>
	<%if(list!=null) {
		%>
		<%if(list.isEmpty()){ %>
		<h3>No data Found</h3>
		
		<%
	}else{
		%>
		<!--Task------>
		<table>
		<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Email</th>
		</tr>
		<%  for(EmployeeBean employee:list){ %>
		<tr>
		<td><%= employee.getId() %></td>
		<td><%= employee.getName() %></td>
		<td><%= employee.getEmail() %></td>
		</tr>
		<% } %>	
		</table>
	<% 
	}
		%>
		<%
	}
		%>
</body>
</html>