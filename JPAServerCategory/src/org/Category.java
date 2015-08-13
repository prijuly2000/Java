package org;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Category")

public class Category
{
	@Id
	@Column(name="catId")
	
	Integer catId;
	
	@Column(name="catName")
	String catName;
	
	@Column(name="catDesc")
	String catDesc;
	
	@Column(name="catImage")
	String catImage;

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

	public Category(Integer catId, String catName, String catDesc, String catImage)
	{
		super();
		this.catId = catId;
		this.catName = catName;
		this.catDesc = catDesc;
		this.catImage = catImage;
	}
	
	public Category()
	{}
	

}
