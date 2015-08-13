package org;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RetreiveSession
 */
public class RetreiveSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession(false);
		PrintWriter out=response.getWriter();
		if(session==null)
		{
			out.println("No Sesion for User..Na NA NA NA");
			return;
		}
		Cookie []arrCookie=request.getCookies();
		for(Cookie objCookie:arrCookie)
		{
			if(objCookie.getName().equals("jsessionId"))
			{
				objCookie.setMaxAge(500);
				response.addCookie(objCookie);
			}
		}
		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<Welcome user<b>"+session.getAttributeNames());
		out.println("<td>"+session.getId()+"</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		
		
		
	}

}
