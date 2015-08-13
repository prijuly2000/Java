<%@page import="org.hibernate.service.ServiceRegistry"%>
<%@page import="org.hibernate.service.ServiceRegistryBuilder"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.Student"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.hibernate.Query"%>
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
<%
	String criteria=request.getParameter("criteria");
	String data=request.getParameter("txt");
	System.out.println("Display Fired..");
	
	/*
	Session hiberSession=null;
	SessionFactory factory=null;
	Configuration cfg=new Configuration();
	cfg.configure("Hib.cfg.xml");
	ServiceRegistryBuilder builder=new ServiceRegistryBuilder();
	builder.applySettings(cfg.getProperties());
	ServiceRegistry registry=builder.buildServiceRegistry();
	factory=cfg.buildSessionFactory(registry);
	System.out.println(criteria);
	System.out.println(data);
	Query query=hiberSession.createQuery("select object(student) from Student student where :criteria=:data");
	
	query.setString("criteria", "student."+criteria);
	query.setString("data", data);
	Iterator<Student> iter=query.iterate();
	
	if(iter.hasNext())
	{
		Student obj=(Student)iter.next();
		out.println(obj.getId());
		out.println(obj.getName());
		out.println(obj.getCity());
		out.println(obj.getPin());
		out.println(obj.getEmail());
		out.println(obj.getMobile());
	}
	else
	{
		out.println("No student");
	}
	
	*/
	Connection connection=null;
	ResultSet result=null;
	PreparedStatement psSelect=null;
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	connection=DriverManager.getConnection("jdbc:oracle:thin:@172.25.12.1:1521:orcl","user101","user101");
	psSelect=connection.prepareStatement("select * from Student where "+criteria+"='"+data+"'");
	result=psSelect.executeQuery();
	if(result.next())
	{
		
		out.println(result.getString(1));
		out.println(result.getString(2));
		out.println(result.getString(3));
		out.println(result.getString(4));
		out.println(result.getString(5));
		out.println(result.getString(6));
		
	}
	else
	{
		out.println("No student");
	}
	
%>
</body>
</html>