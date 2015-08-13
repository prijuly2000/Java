package org;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Entry
{

	
	public static void main(String[] args)
	{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("JetPlane.xml");
		
		JetPlane objPlane=(JetPlane)ctx.getBean("objPlane");
		objPlane.fly();
		objPlane.landSafely();

	}

}
