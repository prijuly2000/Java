<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="lv" class="sun.krd.polling.LoginValidateBean" scope="session" />

	<jsp:setProperty name="lv" property="username" param="uname" />
	<jsp:setProperty name="lv" property="password" param="pass" />

	<%
		if (lv.getValidation()) {
	%>
	<jsp:forward page="pollQue.jsp" />
	<%
		} else {
	%>
	<h2 align="center">Login Failed... <a href="index.jsp">click here</a> To Login Again...</h2>
	<%
		}
	%>

</body>
</html>