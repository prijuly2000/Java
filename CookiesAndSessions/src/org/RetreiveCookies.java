package org;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RetreiveCookies
 */
public class RetreiveCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		Cookie []arrCookies=request.getCookies();
		System.out.println(arrCookies.length);
		if(arrCookies==null)
		{
			out.println("No Cookies");
			return;
		}
		for(Cookie objCookie:arrCookies)
		{
			out.println("<br/>"+objCookie.getName());
			out.println(objCookie.getValue());
			out.println("*******");
			out.println("*******");
		}
		
		
	}

}
