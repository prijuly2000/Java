<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Display.jsp" method="get">
Student by :
<br/>
<table>

<tr>
	<td><input type="radio" name="criteria" value="id">Id </td>
	<td></td>
</tr>

<tr>
	<td><input type="radio" name="criteria" value="name">Name</td>
	<td></td>
</tr>

<tr>
	<td><input type="radio" name="criteria" value="pin">pin</td>
	<td></td>
</tr>

<tr>
	<td><input type="radio" name="criteria" value="email">email</td>
	<td></td>
</tr>

<tr>
	<td>Criteria :</td>
	<td><input type="text" name="txt" ></td>
</tr>

<tr>
	<td></td>
	<td><input type="submit" value="Search" ></td>
</tr>

</table>
</form>
</body>
</html>