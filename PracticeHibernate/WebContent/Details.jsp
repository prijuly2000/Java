<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.service.ServiceRegistryBuilder"%>
<%@page import="org.hibernate.service.ServiceRegistry"%>
<%@page import="org.Student"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.hibernate.Query"%>
<%@page import="java.util.Queue"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
ok
<%
/* Configuration cfg=new Configuration();
cfg.configure("Hib.cfg.xml");

ServiceRegistryBuilder builder=new ServiceRegistryBuilder();
builder.applySettings(cfg.getProperties());

ServiceRegistry registry=builder.buildServiceRegistry();
SessionFactory factory=cfg.buildSessionFactory(registry);
//arg0.getServletContext().setAttribute("hiberFactory",factory );
System.out.println("Factory Registered..."); */



	Session hiberSession =null;
	System.out.println(request.getParameter("criteria"));
	SessionFactory factory=(SessionFactory)application.getAttribute("hiberFactory");
	hiberSession=factory.openSession();
	Query query=hiberSession.createQuery("select object(student) from Student student where student.id=:criteria");
	query.setParameter("criteria", request.getParameter("criteria"));
	Iterator<Student> iter=query.iterate();
	
	if(iter.hasNext())
	{
		Student obj=iter.next();
		out.println(obj.getId());
		out.println(obj.getUserName());
		out.println(obj.getPassword());
		out.println(obj.getName());
		out.println(obj.getEmail());
		
	}
	
	
	
%>
</body>
</html>