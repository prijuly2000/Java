package org;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Entry
{
	public static void main(String[] args)
	{
		Configuration cfg=new Configuration();
		cfg.configure("Hibernate.cfg.xml");
		ServiceRegistryBuilder builder=new ServiceRegistryBuilder();
		builder.applySettings(cfg.getProperties());
		ServiceRegistry registry=builder.buildServiceRegistry();
		SessionFactory factory=cfg.buildSessionFactory(registry);
		Session hiberSession=factory.openSession();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the username");
		String user=scanner.next();
		System.out.println("Enter the password");
		String pwd=scanner.next();
		System.out.println("Enter the name");
		String name=scanner.next();
		System.out.println("Enter the email");
		String email=scanner.next();
		
		Users objUser=new Users(user, pwd, name, email);
		Transaction tx=hiberSession.beginTransaction();
		hiberSession.save(objUser);
		tx.commit();
		System.out.println("User registered...");
	}
}
