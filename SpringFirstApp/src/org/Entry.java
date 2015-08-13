package org;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Entry
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("FirstApp.xml");
		Object obj=ctx.getBean("objCategory");
		System.out.println(obj);
	}

}
