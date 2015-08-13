package org;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection connection=null;
       PreparedStatement psInsert=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@172.25.12.1:1521:orcl","user101","user101");
			psInsert=connection.prepareStatement("Insert into CreditCards values(?,?,?,?)");
			
			String temp=request.getParameter("cardNo");
			long cardNo=Long.parseLong(temp);
			temp=request.getParameter("balance");
			float balance=Float.parseFloat(temp);
			temp=request.getParameter("cvv");
			int cvv=Integer.parseInt(temp);
			String name=request.getParameter("name");
			
			psInsert.setLong(1, cardNo);
			psInsert.setFloat(2, balance);
			psInsert.setInt(3, cvv);
			psInsert.setString(4, name);
			
		int value=psInsert.executeUpdate();
		if(value>0)
		{
			out.println("<html><body><h1> Mr "+name+" is been registred suucessfully</h1></body></html>");
			System.out.println("inserted");
		}
		
		else
		{
			
			out.println("<html><body><h1> Mr "+name+" isnot registered Please try again with another cardNo</h1></body></html>");
			System.out.println("card already exist");
		}
				
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
