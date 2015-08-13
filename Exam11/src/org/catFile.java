package org;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.opensymphony.xwork2.ActionSupport;

public class catFile extends ActionSupport
{
	File catImg;
	String catImgFileName;
	String catImgContentType;
	String catId;
	String catName;
	String catDesc;
	
	SessionFactory factory;
	public String execute()
	{
		try
		{
			System.out.println("File Upload Execute fired");
			FileUtils.copyFile(catImg, new File("d:\\uploadFolder\\",catImgFileName));
			ServletContext ctx=ServletActionContext.getServletContext();
			factory=(SessionFactory)ctx.getAttribute("hiberFactory");
			Session session=factory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(this);
			tx.commit();
			
			
			
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}


	public File getCatImg()
	{
		return catImg;
	}


	public void setCatImg(File catImg)
	{
		this.catImg = catImg;
	}


	public String getCatImgFileName()
	{
		return catImgFileName;
	}


	public void setCatImgFileName(String catImgFileName)
	{
		this.catImgFileName = catImgFileName;
	}


	public String getCatImgContentType()
	{
		return catImgContentType;
	}


	public void setCatImgContentType(String catImgContentType)
	{
		this.catImgContentType = catImgContentType;
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
	
	
	
}
