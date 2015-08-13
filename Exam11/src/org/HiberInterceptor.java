package org;

import org.apache.struts2.ServletActionContext;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class HiberInterceptor implements Interceptor
{
	SessionFactory factory;

	@Override
	public void destroy()
	{
		if(factory!=null)
			factory.close();

	}

	@Override
	public void init()
	{
				
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception
	{
		if(factory==null)
		{
			Configuration config=new Configuration();
			config.configure("Hib.cfg.xml");
			ServiceRegistryBuilder builder=new ServiceRegistryBuilder();
			builder.applySettings(config.getProperties());
			ServiceRegistry registry=builder.buildServiceRegistry();
			factory=config.buildSessionFactory(registry);
			ServletActionContext.getServletContext().setAttribute("hiberFactory", factory);
			
		}
		return arg0.invoke();
	}

}
