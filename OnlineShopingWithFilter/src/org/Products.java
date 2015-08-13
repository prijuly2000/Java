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


public class Products extends HttpServlet {
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
			if(connection!=null)
				connection.close();
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
			connection=(Connection) context.getAttribute("globalConnection");
			
			psSelect=connection.prepareStatement("select * from products where catID=?");
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
		
		String tmp=request.getParameter("catId");
		int catID=Integer.parseInt(tmp);
		
		try
		{
			PrintWriter out=response.getWriter();
			
			psSelect.setInt(1, catID);
			result=psSelect.executeQuery();
			
			out.println("<html>");
			out.println("<body>");
			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("<th>Name</th>");
			out.println("<th>Description</th>");
			out.println("<th>Price</th>");
			out.println("<th>ImageUrl</th>");
			out.println("<th></th>");
			out.println("</tr>");
			
			while(result.next())
			{
				out.println("<tr>");
				out.println("<td>"+result.getString("prodName")+"</td>");
				out.println("<td>"+result.getString("prodDesc")+"</td>");
				out.println("<td>"+result.getString("prodPrice")+"</td>");
				out.println("<td><img src='Images/"+result.getString("prodImg")+"' height='60' width='60' alt='no-Image'/></td>");
				out.println("<td><a href='AddCart?catId="+result.getInt("catId")+"&prodId="+result.getInt("prodId")+"&prodPrice="+result.getFloat("prodPrice")+"&qty=1'>Add to Cart</a></td>");
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
