package org;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String name=request.getParameter("password");
		String email=request.getParameter("email");
		System.out.println(userName+" "+password+" "+name);
		
		Connection connection=null;
		PreparedStatement psStatement=null;
		ResultSet result=null;
		
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection=DriverManager.getConnection("jdbc:Oracle:thin:@172.25.12.1:1521:orcl","user101","user101");
				
				psStatement=connection.prepareStatement("insert into Users values(?,?,?,?)");
				
				psStatement.setString(1, userName);
				psStatement.setString(2, password);
				psStatement.setString(3, name);
				psStatement.setString(4, email);
				
				
				psStatement.executeUpdate();
				System.out.println("Registered");
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
			finally
			{
				try
				{
					if(connection!=null)
						connection.close();
					if(result!=null)
						result.close();
					if(psStatement!=null)
						psStatement.close();
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
	}

}
