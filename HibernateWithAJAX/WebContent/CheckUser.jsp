
<%@page import="org.User"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%-- 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
<%
	Session hiberSession=null;
	
	try
	{
		System.out.println("Check fired");
		
		String name=request.getParameter("userName");
		SessionFactory factory=(SessionFactory)application.getAttribute("hiberFactory");
		System.out.println(name);
		hiberSession=factory.openSession();
		Query query=hiberSession.createQuery("select object(user) from User user where user.userName=:name");
		query.setString("name",name);
		Iterator<User> iter=query.iterate();
		
		if(iter.hasNext())
		{
			out.println("<font color='red'>USername already in use</font>");
			
		}
		else
		{
			out.println("<font color='green'>Username Avail</font>");
		}
	}
	finally
	{
		if(hiberSession!=null)
			hiberSession.close();
	}
	
%>