<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
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
	<table border="1">
	
		<tr>
			<th>Name</th>
			<th>Desc</th>
			<th>ImgUrl</th>		
		</tr>
		<%
			Connection connection=null;
			PreparedStatement psSelect=null;
			ResultSet result=null;
			
			try
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@172.25.12.1:1521:orcl","user101","user101");
			psSelect=connection.prepareStatement("select * from category");
			result=psSelect.executeQuery();
			
			while(result.next())
			{
			
		%>
		
		<tr>
			<td><a href='Products.jsp?catId=<%=result.getInt("catId") %>'><%= result.getString("catName") %></a></td>
			<td><%=result.getString("catDesc") %></td>
			<td><img src='Images/<%= result.getString("catImage") %>' height='60' width='60' alt='no image'/></td>
		</tr>
		<%
			}
			}
			finally
			{
				if(result!=null)
					result.close();
				if(psSelect !=null)
					psSelect.close();
				
			}
			
			%>	
	</table>
</body>
</html>