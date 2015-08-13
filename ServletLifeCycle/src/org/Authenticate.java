package org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection connection =null;
	PreparedStatement psSelect=null;
	
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException
	{
		// TODO Auto-generated method stub
		super.init(config);
		try
		{
			/*String driver=config.getInitParameter("driver");
			String url=config.getInitParameter("dbUrl");
			String user=config.getInitParameter("userName");
			String pwd=config.getInitParameter("password");*/
			
			ServletContext context=getServletContext();
			connection=(Connection)context.getAttribute("globalConnection");
			
			
			 
			
			/*Class.forName(driver);
			connection=DriverManager.getConnection(url,user,pwd);
			context.setAttribute("globalConnection", connection);*/
			
			
			psSelect=connection.prepareStatement("select * from users where userName=? and password=?");
		} 
		
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}




	@Override
	public void destroy()
	{
		try
		{
			if(psSelect!=null)
				psSelect.close();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		ResultSet result=null;
		
		try
		{
			PrintWriter out=response.getWriter();
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			
			session.setAttribute("userName", userName);
			
			psSelect.setString(1, userName);
			psSelect.setString(2, password);
			
			result=psSelect.executeQuery();
			
			if(result.next())
			  response.sendRedirect("Category");
			else
			  response.sendRedirect("index.html");
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(result!=null)
					result.close();
				
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}

}
