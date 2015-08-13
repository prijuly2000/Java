<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="objUser" class="org.User"/>
<jsp:setProperty property="*" name="objUser"/>
<%
	Session hiberSession=null;
	try
	{
		SessionFactory factory=(SessionFactory)application.getAttribute("hiberFact");
		hiberSession=factory.openSession();
		hiberSession.beginTransaction();
		hiberSession.save(objUser);
		hiberSession.getTransaction().commit();
	}
	finally
	{
		if(hiberSession!=null)
			hiberSession.close();
	}
%>
</body>
</html>