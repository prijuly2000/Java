package org;

import javax.servlet.ServletContext;


import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterUser 
{
	String userName;
	String password;
	String name;
	String email;
	
	
	public String getUserName()
	{
		return userName;
	}


	public void setUserName(String userName)
	{
		this.userName = userName;
	}


	public String getPassword()
	{
		return password;
	}


	public void setPassword(String password)
	{
		this.password = password;
	}


	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public String getEmail()
	{
		return email;
	}


	public void setEmail(String email)
	{
		this.email = email;
	}


	public String execute()
	{
		Session hiberSession=null;
		
		try
		{
			ServletContext context=ServletActionContext.getServletContext();
			SessionFactory factory=(SessionFactory)context.getAttribute("hiberFactory");
			hiberSession=factory.openSession();
			Transaction trx=hiberSession.beginTransaction();
			hiberSession.save(this);
			trx.commit();
			return "success";
		}
		catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failure";
		}
		finally
		{
			if(hiberSession!=null)
				hiberSession.close();
		}
		
	}
	

}
