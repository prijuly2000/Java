<%@page import="org.CardsLocal"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	InitialContext ctx=new InitialContext();
	CardsLocal local=(CardsLocal)ctx.lookup("CardsLocal/local");
	boolean flag=local.validate(12, 223.3f);
%>
<h1><%= flag %></h1>
</body>
</html>