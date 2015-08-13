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

/**
 * Servlet implementation class Category
 */
public class Category extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection connection=null;
		PreparedStatement psSelect=null;
		ResultSet result=null;
		
		try
		{
			PrintWriter out=response.getWriter();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@172.25.12.1:1521:orcl","user101","user101");
			
			psSelect=connection.prepareStatement("select * from category");
			result=psSelect.executeQuery();
			
			out.println("<html>");
			out.println("<body>");
			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("<th>Name</th>");
			out.println("<th>Description</th>");
			out.println("<th>ImageUrl</th>");
			out.println("</tr>");
			
			
			while(result.next())
			{
				out.println("<tr>");
				out.println("<td><a href='Products?catID="+result.getInt("catID")+"'>"+result.getString("catName")+"</td>");
				out.println("<td>"+result.getString("catDesc")+"</td>");
				out.println("<td><img src='Images/"+result.getString("catImage")+"'height='60' width='60' alt='noImage'/></td>");
				
				out.println("</tr>");
				
			}
			
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
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
		
		finally
		{
			try
			{
				if(connection!=null)
					connection.close();
				if(psSelect!=null)
					psSelect.close();
				if(result!=null)
					result.close();
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

}
