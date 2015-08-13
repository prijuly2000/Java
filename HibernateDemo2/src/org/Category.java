package org;

public class Category
{
	Integer catId;
	String catName;
	String catDesc;
	String catImage;
	
	public Category()
	{}
	public Category(Integer catId, String catName, String catDesc,
			String catImage)
	{
		super();
		this.catId = catId;
		this.catName = catName;
		this.catDesc = catDesc;
		this.catImage = catImage;
	}
	public Integer getCatId()
	{
		return catId;
	}
	public void setCatId(Integer catId)
	{
		this.catId = catId;
	}
	public String getCatName()
	{
		return catName;
	}
	public void setCatName(String catName)
	{
		this.catName = catName;
	}
	public String getCatDesc()
	{
		return catDesc;
	}
	public void setCatDesc(String catDesc)
	{
		this.catDesc = catDesc;
	}
	public String getCatImage()
	{
		return catImage;
	}
	public void setCatImage(String catImage)
	{
		this.catImage = catImage;
	}
	
	

}
