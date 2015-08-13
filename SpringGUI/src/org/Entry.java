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
		ApplicationContext ctx=new ClassPathXmlApplicationContext("GUI.xml");
		ctx.getBean("objMainFrame");
		
	}

}
