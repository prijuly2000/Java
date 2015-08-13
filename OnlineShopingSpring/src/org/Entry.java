package org;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Entry
{

	
	public static void main(String[] args)
	{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("Cart.xml");
		Cart objCart=(Cart)ctx.getBean("objCart");
		objCart.addToCart(1, 1, 100);
		objCart.removeFromCart(1,1);
		objCart.listCart();

	}

}
