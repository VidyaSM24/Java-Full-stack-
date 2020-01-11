<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page session="false" %>

<html>
<body>
	<form action="./login" method="post">
		<table>
			<tr>
				<td>User Name:</td>
				<td><input type="text" name="username"></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"></td>
			</tr>

			<tr>

				<td><input type="submit" value="Login"></td>
			</tr>


		</table>
	</form>
</body>
</html>