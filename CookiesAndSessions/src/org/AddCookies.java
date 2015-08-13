package org;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCookies
 */
public class AddCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Cookie objCookie=new Cookie("userName", "pritesh");
		Cookie objDate=new Cookie("lastVisited",new Date().toString());
		
		objCookie.setMaxAge(30000);
		response.addCookie(objCookie);
		//response.getWriter().println("objCookie Added");
		objDate.setMaxAge(1000);
		response.addCookie(objDate);
		//response.getWriter().println("objDate Added");
		
	}

}
