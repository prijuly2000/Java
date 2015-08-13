package org;

public class Student
{
	String id;
	String userName;
	String password;
	String name;
	String email;
	
	public Student()
	{}

	public Student(String id, String userName, String password, String name,
			String email)
	{
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
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
