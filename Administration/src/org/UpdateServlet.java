package org;

import java.io.IOException;
import java.io.PrintWriter;
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

public class UpdateServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
	
	@Override
	public void init(ServletConfig config) throws ServletException
	{
		// TODO Auto-generated method stub
		super.init(config);
		
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection connection=null;
		PreparedStatement psSelect =null;
		ResultSet result=null;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@172.25.12.1:1521:orcl","user101","user101");
			psSelect =connection.prepareStatement("select catId from category");
			result=psSelect.executeQuery();
			
			
			PrintWriter out=response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<form action='PostUpdate' method='post'>");
			out.println("Cat Id:");
			out.println("<select name='catId'>");
			while (result.next())
			{
				out.println("<option value='"+result.getInt("catId")+"'>"+result.getInt("catId")+"</option>");
			}
			out.println("</select><br/>");
			out.println("Name:");
			out.println("<input type='text' name='catName'><br/>");
			out.println("Desc:");
			out.println("<input type='text' name='catDesc'><br/>");
			out.println("ImgUrl:");
			out.println("<input type='text' name='catImg'><br/>");
			out.println("<input type='submit' value='submit'><br/>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			response.sendRedirect("index.html");
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
