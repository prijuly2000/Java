<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Register.jsp" method="get">

<table>

<tr>
	<td>Id:</td>
	<td><input type="text" name="id"></td>
</tr>

<tr>
	<td>Name:</td>
	<td><input type="text" name="name"></td>
</tr>

<tr>
	<td>City:</td>
	<td><input type="text" name="city"></td>
</tr>

<tr>
	<td>Pin:</td>
	<td><input type="text" name="pin"></td>
</tr>

<tr>
	<td>email:</td>
	<td><input type="text" name="email"></td>
</tr>

<tr>
	<td width="120">Mobile No:</td>
	<td><input type="text" name="mobile"></td>
</tr>

<tr>
	<td><a href="FindStudent.jsp">Find Student</a></td>
	<td><input type="submit" value="Register"></td>
</tr>
</table>

</form>
</body>
</html>