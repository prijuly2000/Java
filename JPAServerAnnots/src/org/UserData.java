package org;

import java.io.Serializable;

public class UserData implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String userName;
	String password;
	String name;
	String email;
	
	public UserData()
	{}

	public UserData(String userName, String password, String name, String email)
	{
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.email = email;
	}

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
	
	
}
