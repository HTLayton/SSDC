<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="register" method="post">
	<table style="with: 50%">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName"/></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName"/></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td>UserName</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				</table>
				<input type="submit" value="Submit" />
</form>
</body>
</html>