package org;

public class Admission
{
	String name;
	String email;
	String classJoin;
	Integer mobile;
	public Admission()
	{}
	
	public Admission(String name, String email, String classJoin, Integer mobile)
	{
		super();
		this.name = name;
		this.email = email;
		this.classJoin = classJoin;
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
	public String getClassJoin()
	{
		return classJoin;
	}
	public void setClassJoin(String classJoin)
	{
		this.classJoin = classJoin;
	}
	public Integer getMobile()
	{
		return mobile;
	}
	public void setMobile(Integer mobile)
	{
		this.mobile = mobile;
	}

}
