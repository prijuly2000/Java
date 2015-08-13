package org;

public class Product
{
	ProductID pId;
	String prodName;
	String prodDesc;
	String prodImgUrl;
	float prodPrice;
	
	public Product()
	{}

	
	public Product(ProductID pId, String prodName, String prodDesc,
			String prodImgUrl, float prodPrice)
	{
		super();
		this.pId = pId;
		this.prodName = prodName;
		this.prodDesc = prodDesc;
		this.prodImgUrl = prodImgUrl;
		this.prodPrice = prodPrice;
	}


	public ProductID getpId()
	{
		return pId;
	}

	public void setpId(ProductID pId)
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

	public String getProdImgUrl()
	{
		return prodImgUrl;
	}

	public void setProdImgUrl(String prodImgUrl)
	{
		this.prodImgUrl = prodImgUrl;
	}

	public float getProdPrice()
	{
		return prodPrice;
	}

	public void setProdPrice(float prodPrice)
	{
		this.prodPrice = prodPrice;
	}
	
	
}
