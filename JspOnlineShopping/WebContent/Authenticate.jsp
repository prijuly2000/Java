<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
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

<% 
	Connection connection=null;
	PreparedStatement psSelect=null;
	ResultSet result=null;
	
try
{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	connection=DriverManager.getConnection("jdbc:oracle:thin:@172.25.12.1:1521:orcl","user101","user101");
	psSelect=connection.prepareStatement("select * from users where userName=? and password=?");
	
	psSelect.setString(1, request.getParameter("userName"));
	psSelect.setString(2,request.getParameter("password"));
	
	result= psSelect.executeQuery();
	
	if(result.next())
		response.sendRedirect("Category.jsp");
	else
	{
%>
	<font color="red">Invalid username/password</font>
	<jsp:include page="index.jsp"></jsp:include>
	
<%
	}
}
	finally
	{
		if(result!=null)
			result.close();
		if(psSelect!=null)
			psSelect.close();
		if(connection!=null)
			connection.close();
		
	}
%>
</body>
</html>