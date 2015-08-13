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

/**
 * Servlet implementation class Category
 */
public class Category extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection connection=null;
	PreparedStatement psSelect=null;

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
	
	@Override
	public void init(ServletConfig config) throws ServletException
	{
		// TODO Auto-generated method stub
		super.init(config);
		try
		{
			ServletContext context=getServletContext();
			connection=(Connection)context.getAttribute("globalConnection");
			
			psSelect=connection.prepareStatement("select * from category");
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		ResultSet result=null;
		
		try
		{
			PrintWriter out=response.getWriter();
			
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
				out.println("<td><a href='Products?catId="+result.getInt("catID")+"'>"+result.getString("catName")+"</a></td>");
				out.println("<td>"+result.getString("catName")+"</td>");
				out.println("<td>"+result.getString("catDesc")+"</td>");
				out.println("<td><img src='Images/"+result.getString("catImage")+"'height='60' width='60' alt='noImage'/></td>");
				
				out.println("</tr>");
				
			}
			
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
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
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

}
