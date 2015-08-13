<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3 align="center">Sign In</h3>
	<form method="post" action="loginvalidate.jsp">
		<table align=center border=0 bgcolor="#cccccc">
			<tr>
				<td>User Name:<td>
				<td><input type="text" name=uname><td>
			</tr>
			<tr>
				<td>Password:<td>
				<td><input type="Password" name=pass>	<td>
			</tr>
			<tr>
				<td colspan="3" align=center><input type="submit" value="Login"><td>
			</tr>
		</table>
	</form>
</body>
</html>