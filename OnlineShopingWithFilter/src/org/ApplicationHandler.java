package org;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationHandler implements ServletContextListener
{
	
	Connection connection=null;
	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{
		System.out.println("The application "+arg0.getServletContext().getServletContextName()+" is terminated");
		
		try
		{
			if(connection!=null)
				connection.close();
			
			ServletContext context=arg0.getServletContext();
			context.removeAttribute("globalConnection");
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0)
	{
		System.out.println("The application "+arg0.getServletContext().getServletContextName()+" has sucessfully started");
		
			
		try
		{
			ServletContext context=arg0.getServletContext();
			String driver=context.getInitParameter("driver");
			String url=context.getInitParameter("dbUrl");
			String user=context.getInitParameter("userName");
			String pwd=context.getInitParameter("password");
			Class.forName(driver);
			connection=DriverManager.getConnection(url,user,pwd);
			context.setAttribute("globalConnection", connection);
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
