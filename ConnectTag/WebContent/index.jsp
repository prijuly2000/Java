<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="/database-tags" prefix="ntpritz" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<td>Name</td>
<td>Description</td>
<td>Image</td>
</tr>
<ntpritz:connect password="user101" url="jdbc:oracle:thin:@172.25.12.1:1521:orcl" userName="user101" driver="oracle.jdbc.driver.OracleDriver">


<ntpritz:query sql="select * from category">
<jsp:useBean id="result" scope="page" type="org.Category"/>
<tr>
	<td>
		<jsp:getProperty name="result" property="catName" />
	</td>
	<td>
		<jsp:getProperty name="result" property="catDesc" />
	</td>
	<td>
		<jsp:getProperty name="result" property="catImage" />
	</td>	
 </tr>
 
</ntpritz:query>

</ntpritz:connect>
</table>

</body>
</html>