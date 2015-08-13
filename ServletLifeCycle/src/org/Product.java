package org;

public class Product
{
	int catId;
	int prodId;
	int qty;
	float price;
	
	
	
	public Product(int catId, int prodId, int qty, float price)
	{
		
		this.catId = catId;
		this.prodId = prodId;
		this.qty = qty;
		this.price = price;
	}
	public int getCatId()
	{
		return catId;
	}
	public void setCatId(int catId)
	{
		this.catId = catId;
	}
	public int getProdId()
	{
		return prodId;
	}
	public void setProdId(int prodId)
	{
		this.prodId = prodId;
	}
	public int getQty()
	{
		return qty;
	}
	public void setQty(int qty)
	{
		this.qty = qty;
	}
	public float getPrice()
	{
		return price;
	}
	public void setPrice(float price)
	{
		this.price = price;
	}
	

}
