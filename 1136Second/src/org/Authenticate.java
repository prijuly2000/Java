package org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

/**
 * Servlet implementation class Authenticate
 */
@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Authenticate() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String user=request.getParameter("userName");
		String pwd=request.getParameter("password");
		System.out.println(user+" "+pwd);
		

		Connection connection=null;
		PreparedStatement psStatement=null;
		ResultSet result=null;
		
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					connection=DriverManager.getConnection("jdbc:Oracle:thin:@172.25.12.1:1521:orcl","user101","user101");
					
					psStatement=connection.prepareStatement("select * from Users where username=? and password=?");
					
					psStatement.setString(1, user);
					psStatement.setString(2, pwd);
					System.out.println(psStatement);
					
					result=psStatement.executeQuery();
					PrintWriter out=response.getWriter();
					if(result.next())
					{
						out.println("<font color='green'><h1>Welcome "+user+"</h1></font>");
					}
					else
					{
						out.println("<font color='red'><h1>You have to register first</h1></font>");
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
