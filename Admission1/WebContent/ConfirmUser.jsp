<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="objUser" class="pojo.Admisson" scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="objUser"/>
	Name:<jsp:getProperty property="name" name="objUser"/>
	Email:<jsp:getProperty property="email" name="objUser"/>
	Class:<jsp:getProperty property="clas" name="objUser"/>
	Mobile:<jsp:getProperty property="mobile" name="objUser"/>
	<a href='Register.jsp'>Confirm</a>&nbsp;
	&nbsp;
	&nbsp;
	&nbsp;
	<a href='index.jsp'>Cancel</a>
</body>
</html>