package org;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	
    Connection connection=null;
    PreparedStatement psInsert=null;
	@Override
	public void destroy()
	{
		try
		{
			if(connection!=null)
				connection.close();
			if(psInsert!=null)
				psInsert.close();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException
	{
		// TODO Auto-generated method stub
		super.init(config);
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@172.25.12.1:1521:orcl","user101","user101");
			psInsert=connection.prepareStatement("insert into category values(?,?,?,?)");
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



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		int catId=Integer.parseInt(request.getParameter("catId"));
		String catName=request.getParameter("catName");
		String catDesc=request.getParameter("catDesc");
		String catImg=request.getParameter("catImg");
		
		try
		{
			psInsert.setInt(1,catId);
			psInsert.setString(2, catName);
			psInsert.setString(3, catDesc);
			psInsert.setString(4, catImg);
			psInsert.executeUpdate();
			System.out.println("Row Added");
			response.sendRedirect("index.html");
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
