package org;

import java.util.Iterator;

public class ShoppingCart implements Cart
{

	@Override
	public void addToCart(int catId, int prodId, float price)
	{
		System.out.println("Added to Cart");

	}

	@Override
	public void removeFromCart(int catId, int proId)
	{
		System.out.println("Removed from Cart");
		

	}

	@Override
	public Iterator listCart()
	{
		System.out.println("List iterated");
		return null;
	}

}
