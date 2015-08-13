package org.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LanguageFilter implements Filter
{
	

	@Override
	public void destroy()
	{
		System.out.println("Filter Destroyed....");

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException
	{
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		
		String msg=request.getParameter("message");
		if(msg=="")
			return;
		if(msg.indexOf("mad")!=-1 ||msg.indexOf("idiot")!=-1 || msg.indexOf("stupid")!=-1 || msg.indexOf("non-sense")!=-1 || msg.indexOf("insane")!=-1 || msg.indexOf("crap")!=-1)
		{
			response.sendRedirect("NotAllowed.html");
		}
		else
		{
			
			arg2.doFilter(arg0, arg1);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException
	{
		System.out.println("Filter Started....");

	}
	


}
