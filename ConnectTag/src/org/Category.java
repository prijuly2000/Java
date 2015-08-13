package org;

public class Category
{
	String catName;
	String catDesc;
	String catImage;
	
	public Category()
	{
		
		
	}
	
	public Category(String catName, String catDesc, String catImage)
	{
		super();
		this.catName = catName;
		this.catDesc = catDesc;
		this.catImage = catImage;
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
