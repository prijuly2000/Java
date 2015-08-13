<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="/database-tags" prefix="fi" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

int count=0;
Connection connection=null;
PreparedStatement psSelect=null;
PreparedStatement psInsert=null;
ResultSet result=null;

 Class.forName("oracle.jdbc.driver.OracleDriver");
connection=DriverManager.getConnection("jdbc:oracle:thin:@172.25.12.1:1521:orcl","user101","user101"); 




psSelect=connection.prepareStatement("select * from Admission");
psInsert=connection.prepareStatement("insert into Admission values(?,?,?,?)");
String name=request.getParameter("name");
String email=request.getParameter("email");
String mobile=request.getParameter("mobile");
String classj=request.getParameter("select");
int m=Integer.parseInt(mobile);
psInsert.setString(1, name);
psInsert.setString(2, classj);
psInsert.setString(3, email);
psInsert.setString(4,mobile);
result=psSelect.executeQuery();
while(result.next())
{
	count++;
}
if(count<10)
{
	psInsert.executeUpdate();
	System.out.println("admission done");
%><h1>Admission Done</h1>
<%}
else
{
	System.out.println("class is full");	
	%><h1>Admission Full</h1>
<%}
		

%>



</body>
</html>