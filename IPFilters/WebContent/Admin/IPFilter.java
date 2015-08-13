package org;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IPFilter implements Filter
{

	@Override
	public void destroy()
	{
		System.out.println("IP filter has been destroyed");
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException
	{
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		
		String address=request.getRemoteAddr();
		if(!(address.startsWith("127.0.0")||address.startsWith("0.0.0.0")||address.equals("172.25.12.148")))
		{
			System.out.println("user authorized");
			arg2.doFilter(arg0, arg1);
		}
		else
		{
			System.out.println("your IP is"+address+"You are Banned on this Website"+response.sendRedirect(request.getContextPath()+"/unAuthorized.html"));
		}
		

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException
	{
		System.out.println("Filter Activated");

	}

}
