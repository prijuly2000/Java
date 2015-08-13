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


public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection connection=null;
		PreparedStatement psSelect=null;
		ResultSet result=null;
		
		String tmp=request.getParameter("catID");
		int catID=Integer.parseInt(tmp);
		
		try
		{
			PrintWriter out=response.getWriter();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:Oracle:thin:@172.25.12.1:1521:orcl","user101","user101");
			
			psSelect=connection.prepareStatement("select * from products where prodID=?");
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
			out.println("</tr>");
			
			while(result.next())
			{
				out.println("<tr>");
				out.println("<td>"+result.getString("productName")+"</td>");
				out.println("<td>"+result.getString("productDesc")+"</td>");
				out.println("<td>"+result.getString("productPrice")+"</td>");
				out.println("<td><img src='Images/"+result.getString("productImage")+"' height='60' width='60' alt='no-Image'></td>");
				//out.println("<td><a href='Images/"+result.getString("productImage")+"'>"+result.getString("productName")+"</a></td>");
				out.println("</tr>");
				
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
