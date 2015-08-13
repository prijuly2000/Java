package org;

import java.util.Iterator;

public interface Cart
{
	public void addToCart(int catId,int prodId,float price);
	public void removeFromCart(int catId,int proId);
	public Iterator listCart();
	

}
