package org;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddSessions
 */
public class AddSessions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		session.setAttribute("userName", "Neeraj");
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Add Session</h1>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td>Id</td>");
		out.println("<td>"+session.getId()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>LastAccessedTime</td>");
		out.println("<td>"+new Date(session.getLastAccessedTime())+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>CreationTime</td>");
		out.println("<td>"+new Date(session.getCreationTime())+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>MaxInactiveTime</td>");
		out.println("<td>"+(session.getMaxInactiveInterval())+"</td>");
		out.println("</tr>");
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		
	
	}

}
