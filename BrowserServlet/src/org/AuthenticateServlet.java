package org;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

public class AuthenticateServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		String user=request.getParameter("userName");
		String pwd=request.getParameter("password");
		if(user.equals("pritz") && pwd.equals("rachana"))
			out.println("Successful login");
		else
			out.println("wrong username or password");
		
		
				
		
		out.println("</body>");
		out.println("</html>");
	}
	
}
