package org;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderServlets extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th>Name</th>");
		out.println("<th>value</th>");
		out.println("</tr>");
		
		Enumeration<String>enm=request.getHeaderNames();
		while(enm.hasMoreElements())
		{
			String name=enm.nextElement();
			String value=request.getHeader(name);
			
			out.println("<tr>");
			out.println("<td>"+name+"</td>");
			out.println("<td>"+value+"</td>");
			out.println("</tr>");
			
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		
	}
	

}
