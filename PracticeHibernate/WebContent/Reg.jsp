
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="objStudent" class="org.Student"></jsp:useBean>
<jsp:setProperty property="*" name="objStudent"/>
<%
	Connection con=null;
	PreparedStatement psInsert=null;

	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@172.25.12.1:1521:orcl","user101","user101");
	psInsert=con.prepareStatement("insert into Student values(?,?,?,?,?)");
	psInsert.setString(1, objStudent.getId());
	psInsert.setString(2, objStudent.getUserName());
	psInsert.setString(3, objStudent.getPassword());
	psInsert.setString(4, objStudent.getName());
	psInsert.setString(5, objStudent.getEmail());
	
	psInsert.executeUpdate();
	out.print("<h1>Registered....</h1>");
	
%>
</body>
</html>