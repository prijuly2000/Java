package org;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BrowserIdentifier extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		String browser=request.getHeader("user-agent");
		if(browser.indexOf("MSIE")!=-1)
			out.println("Microsoft Internet Explorer");
		else if(browser.indexOf("Firefox")!=-1)
			out.println("Mozilla Firefox");
		else if(browser.indexOf("Chrome")!=-1)
			out.println("Google Chrome");
		else
			out.println("Other browser");
		
		out.println("</body>");
		out.println("</html>");
	}

	
}
