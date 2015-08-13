package org;

public class Product
{
	
	CompositKey pId;
	String prodName;
	String prodDesc;
	String prodImg;
	
	public Product()
	{
		
	}
	public Product(CompositKey pId, String prodName, String prodDesc,
			 String prodImg)
	{
		super();
		this.pId = pId;
		this.prodName = prodName;
		this.prodDesc = prodDesc;
		
		this.prodImg = prodImg;
	}
	public CompositKey getpId()
	{
		return pId;
	}
	public void setpId(CompositKey pId)
	{
		this.pId = pId;
	}
	public String getProdName()
	{
		return prodName;
	}
	public void setProdName(String prodName)
	{
		this.prodName = prodName;
	}
	public String getProdDesc()
	{
		return prodDesc;
	}
	public void setProdDesc(String prodDesc)
	{
		this.prodDesc = prodDesc;
	}
	
	public String getProdImg()
	{
		return prodImg;
	}
	public void setProdImg(String prodImg)
	{
		this.prodImg = prodImg;
	}
	

}
