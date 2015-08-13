package org;

public class Student
{
	String id;
	String name;
	String city;
	String pin;
	String email;
	String mobile;
	
	public Student()
	{}

	public Student(String id, String name, String city, String pin,
			String email, String mobile)
	{
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.pin = pin;
		this.email = email;
		this.mobile = mobile;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getPin()
	{
		return pin;
	}

	public void setPin(String pin)
	{
		this.pin = pin;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
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
