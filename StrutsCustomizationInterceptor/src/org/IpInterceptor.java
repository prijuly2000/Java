package org;

import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class IpInterceptor implements Interceptor
{

	@Override
	public void destroy()
	{
		System.out.println("Interceptor destroyed");

	}

	@Override
	public void init()
	{
		System.out.println("Interceptor Fired");

	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		String addr=request.getRemoteAddr();
		if(addr.startsWith("127.0")||addr.startsWith("0:0:0:0")||addr.equals("172.25.12.148"))
		{
			System.out.println("you are a local client");
			
		}
		else
		{
			System.out.println("you are not a local client");
			return "invalidip";
		}
		return arg0.invoke();
	}

}
