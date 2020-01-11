<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <jsp:useBean id="user" class="com.capgemini.springmvc.beans.User" scope="session"></jsp:useBean>
    
   
<html>
<body>
<h1>Welcome <%=user.getName() %></h1>
</body>
</html>