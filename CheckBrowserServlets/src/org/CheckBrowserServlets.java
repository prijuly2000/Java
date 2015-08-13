package org;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

public class CheckBrowserServlets extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		String browser=request.getHeader("user-agent");
		if(browser.indexOf("MSIE")!=-1)
			out.println("You r Using Microsoft IE");
		else if(browser.indexOf("Firefox")!=-1)
			out.println("you are using FireFox");
		else if(browser.indexOf("Chrome")!=-1)
			out.println("you are using google chrome");
		else
			out.println("u are using some other browser");
	}
	

}
