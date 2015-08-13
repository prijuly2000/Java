package org;

import java.io.Serializable;

public class CompositKey implements Serializable
{
	Integer catId;
	Integer prodId;
	
	public CompositKey()
	{
		
	}
	public CompositKey(Integer catId, Integer prodId)
	{
		super();
		this.catId = catId;
		this.prodId = prodId;
	}
	public Integer getCatId()
	{
		return catId;
	}
	public void setCatId(Integer catId)
	{
		this.catId = catId;
	}
	public Integer getProdId()
	{
		return prodId;
	}
	public void setProdId(Integer prodId)
	{
		this.prodId = prodId;
	}
	
	

}
