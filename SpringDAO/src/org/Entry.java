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
		ApplicationContext ctx=new ClassPathXmlApplicationContext("dao.xml");
		
		CategoryDAO objDAO=(CategoryDAO)ctx.getBean("objCategoryDAO");
		objDAO.saveCategory((Category)ctx.getBean("objCategory"));
		

	}

}
