<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:useBean id="lv" class="sun.krd.polling.LoginValidateBean" />
</head>
<body>
	<form action="ratings.jsp">
		<h2 align="center">Question Of The Day</h2>
		<hr>
		<table border="0" bgcolor="#CCCCCC" align="center">
			<tr>
				<td colspan="3">In this year Sachin Tendulkar will retired or	not?</td>
			</tr>
			<tr>
				<td>Answer.</td>
				<td align="right">1.</td>
				<td><input type="radio" name="ans" value="yes"> Yes</td>
			</tr>
			<tr>
				<td colspan="2" align="right">2.</td>
				<td><input type="radio" name="ans" value="no">No</td>
			</tr>
			<tr>
				<td colspan="2" align="right">3.</td>
				<td><input type="radio" name="ans" value="cantsay">Can't say</td>
			</tr>
			<tr>
				<td colspan="3" align="right"><input type="submit" value="rate"></td>
			</tr>
		</table>
	</form>
</body>
</html>