<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:useBean id="rating" class="sun.krd.polling.PollBean"  scope="application"/>
<jsp:setProperty property="res" name="rating" param="ans" />


<%-- <jsp:setProperty property="yes" name="rating" value="${applicationScope.yes}" />
<jsp:setProperty property="no" name="rating" value="${applicationScope.no}" />
<jsp:setProperty property="cantsay" name="rating" value="${applicationScope.cantsay}" />
 --%><%-- <jsp:setProperty property="total" name="rating" value="${applicationScope.total}" /> --%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ratings</title>
</head>
<body>


	<%
		rating.pollResult();
	
		/* application.setAttribute("yes", rating.getYes());
		application.setAttribute("no", rating.getNo());
		application.setAttribute("cantsay", rating.getCantsay()); */
	//	application.setAttribute("total", rating.getTotal());
	%>
	<table align="center" bgcolor="#cccccc">
		<tr>
			<td align="right">yes=</td>
			<td>${rating.yesRate} %</td>
		</tr>
		<tr>
			<td align="right">no=</td>
			<td>${rating.noRate} %</td>
		</tr>
		<tr>
			<td align="right">can't Say=</td>
			<td>${rating.cantsayRate} %</td>
		</tr>
	</table>
	<hr>
	Thank You...
	<a href="index.jsp">Continue to login..</a>
</body>
</html>