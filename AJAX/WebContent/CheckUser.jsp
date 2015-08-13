<%@page import="org.hibernate.service.ServiceRegistry"%>
<%@page import="org.hibernate.service.ServiceRegistryBuilder"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.User"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%

	Session hiberSession=null;
	try
	{
		Configuration cfg=new Configuration();
		cfg.configure("Hib.cfg.xml");
		
		ServiceRegistryBuilder builder=new ServiceRegistryBuilder();
		builder.applySettings(cfg.getProperties());
		
		ServiceRegistry registry=builder.buildServiceRegistry();
		SessionFactory factory=cfg.buildSessionFactory(registry);
		System.out.println("CheckUser");
		String name=request.getParameter("userName");
		//SessionFactory factory=(SessionFactory)application.getAttribute("hiberFact");
		hiberSession=factory.openSession();
		Query query=hiberSession.createQuery("select object(user) from User user where user.userName=:name");
		query.setString("name", name);
		
		Iterator<User> iter=query.iterate();
		if(iter.hasNext())
		{
			out.println("<font color='red'>Username Exists</font>");
		}
		else
		{
			out.println("<font color='green'>Username Available</font>");
		}
	}
	finally
	{
		if(hiberSession!=null)
			hiberSession.close();
	}
	
	
%>