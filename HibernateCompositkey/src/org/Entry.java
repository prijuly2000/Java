package org;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Entry
{
	public static void main(String[] args)
	{
		SessionFactory factory=null;
		Session hiberSession=null;
		
		try
		{
			Configuration cfg=new Configuration();
			cfg.configure("Hibernate.cfg.xml");
			ServiceRegistryBuilder builder=new ServiceRegistryBuilder();
			builder.applySettings(cfg.getProperties());
			ServiceRegistry registry=builder.buildServiceRegistry();
			factory=cfg.buildSessionFactory(registry);
			hiberSession=factory.openSession();
			
			Product objProduct=(Product)hiberSession.load(Product.class,1);
			System.out.println(objProduct.getProdName());
			System.out.println(objProduct.getProdDesc());
		}
		catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(factory!=null)
				factory.close();
			if(hiberSession!=null)
				hiberSession.close();
		}
		
	}
}
