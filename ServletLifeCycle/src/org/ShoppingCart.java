package org;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShoppingCart
 */
@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet implements Cart
{
	private static final long serialVersionUID = 1L;

	ArrayList<Product>items=new ArrayList<>();
	public void add(Product objProduct)throws CartException
	{
		if(objProduct.getCatId()==0 || objProduct.getProdId()==0 || objProduct.getPrice()<=0)
		{
			throw new CartException("Invalid product details");				
		}
		if(items.size()>0)
		{
			Iterator<Product> iter=(Iterator<Product>)items.iterator();
			while (iter.hasNext())
			{
				Product tmpProduct=iter.next();
				if(tmpProduct.getCatId()==objProduct.getCatId() && tmpProduct.getProdId()==objProduct.getProdId())
				{
					tmpProduct.setQty(tmpProduct.getQty()+1);
					return;
				}
			}
		}
		items.add(objProduct);
	}
	
	public void remove(int catId,int prodId) throws CartException
	{
		if(items.size()>0)
		{
			Iterator<Product> iter=(Iterator<Product>)items.iterator();
			while(iter.hasNext())
			{
				Product tmpProduct=iter.next();
				if(tmpProduct.getCatId()==catId && tmpProduct.getProdId()==prodId)
				{
					items.remove(tmpProduct);
					return;
				}
			}
		}
		else
			throw new CartException("No such product to remove");
	}
	
	public Iterator list() throws CartException
	{
		if(items.size()<=0)
			throw new CartException("Cart Empty");
		else
			return items.iterator();
	}
	
}
