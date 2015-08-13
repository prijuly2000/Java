package org;

import java.util.Iterator;

public interface Cart
{
	public void add(Product objProduct) throws CartException;
	public void remove(int catId,int prodId) throws CartException;
	public Iterator list() throws CartException;
}
