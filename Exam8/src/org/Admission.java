package org;

public class Admission
{
	String name;
	String email;
	String className;
	String mobile;
	
	public Admission()
	{
		
	}

	public Admission(String name, String email, String className, String mobile)
	{
		
		this.name = name;
		this.email = email;
		this.className = className;
		this.mobile = mobile;
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

	public String getClassName()
	{
		return className;
	}

	public void setClassName(String className)
	{
		this.className = className;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}
	

	
}
