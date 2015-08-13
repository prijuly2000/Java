package org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection connection =null;
		PreparedStatement psSelect=null;
		ResultSet result=null;
		
		try
		{
			PrintWriter out=response.getWriter();
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:Oracle:thin:@172.25.12.1:1521:orcl", "user101", "user101");
			psSelect=connection.prepareStatement("select * from users where userName=? and password=?");
			psSelect.setString(1, userName);
			psSelect.setString(2, password);
			
			result=psSelect.executeQuery();
			
			if(result.next())
			  response.sendRedirect("Category");
			else
			  response.sendRedirect("index.html");
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(connection!=null)
					connection.close();
				if(result!=null)
					result.close();
				if(psSelect!=null)
					psSelect.close();
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}

}
