package org;

import javax.servlet.ServletContext;

public class CartFactory
{
	public static Cart getCart(ServletContext context) throws CartException
	{
		Object objCart;
		try
		{
			String cartClass=context.getInitParameter("cartClass");
			Class refClass=Class.forName(cartClass);
			objCart = refClass.newInstance();
			return (Cart)objCart;
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InstantiationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new CartException("Unable to create cart");
		
	}
}
