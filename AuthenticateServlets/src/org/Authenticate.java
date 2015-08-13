package org;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Authenticate extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		
		String user=request.getParameter("userName");
		String pwd=request.getParameter("password");
		
		if(user.equals("neeraj")&&pwd.equals("pritz"))
			out.println("you hav been authorized");
		else
			out.println("invalid user and password");
		
	}
	

}
