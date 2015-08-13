<%@page import="org.hibernate.Query"%>
<%@page import="org.Courses"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%

	Session hiberSession=null;
	try
	{
		System.out.println("AddCourses fired");
		SessionFactory factory=(SessionFactory)application.getAttribute("hiberFactory");
		hiberSession=factory.openSession();
		Query query=hiberSession.createQuery("from Courses");
		Iterator<Courses> iter=(Iterator<Courses>)query.iterate();
		String all="";
		int i=0;
		if(iter.hasNext())
		{
			Courses obj=iter.next();
			all+=obj.getCourseName()+" ";
			System.out.println(all);
			i++;
		}
		System.out.println(i);
		out.println(all);
	}
	finally
	{
		if(hiberSession!=null)
			hiberSession.close();
	}
%>