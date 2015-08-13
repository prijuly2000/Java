package org;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
@WebListener
public class HiberInit implements ServletContextListener
{

	SessionFactory factory;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{
		if(factory!=null)
			factory.close();

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0)
	{
		Configuration cfg=new Configuration();
		cfg.configure("Reg.cfg.xml");
		ServiceRegistryBuilder builder=new ServiceRegistryBuilder();
		builder.applySettings(cfg.getProperties());
		ServiceRegistry registry=builder.buildServiceRegistry();
		factory=cfg.buildSessionFactory(registry);
		arg0.getServletContext().setAttribute("hiberFact", factory);
	}

}
