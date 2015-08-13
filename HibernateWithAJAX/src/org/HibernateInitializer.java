package org;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
@WebListener
public class HibernateInitializer implements ServletContextListener
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
		cfg.configure("Registration.cfg.xml");
		
		ServiceRegistryBuilder builder=new ServiceRegistryBuilder();
		builder.applySettings(cfg.getProperties());
		ServiceRegistry registry=builder.buildServiceRegistry();
		factory=cfg.buildSessionFactory(registry);
		arg0.getServletContext().setAttribute("hiberFactory",factory);
		System.out.println("factory inserted");

	}

}
