package org;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostUpdate
 */
public class PostUpdate extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
	Connection connection=null;
	PreparedStatement psSelect =null;
	ResultSet result=null;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{	
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@172.25.12.1:1521:orcl","user101","user101");
			psSelect =connection.prepareStatement("update category set catName=?, catDesc=?,CATIMAGE=? where catId=?");
			
			psSelect.setString(1, req.getParameter("catName"));
			psSelect.setString(2, req.getParameter("catDesc"));
			psSelect.setString(3, req.getParameter("catImg"));
			psSelect.setInt(4, Integer.parseInt(req.getParameter("catId")));
			psSelect.executeUpdate();
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
