package org.beans;

public class Category
{
	String catId;
	String catName;
	String catDesc;
	String catImg;
	
	
	
	@Override
	public String toString()
	{
		/*return "This is the category class";*/
		
		return catId + " | " + catName + " | "+catDesc+" | "+catImg;
	}
	public String getCatId()
	{
		return catId;
	}
	public void setCatId(String catId)
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
	public String getCatImg()
	{
		return catImg;
	}
	public void setCatImg(String catImg)
	{
		this.catImg = catImg;
	}
	
	
}
