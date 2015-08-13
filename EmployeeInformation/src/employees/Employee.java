package employees;

import java.io.Serializable;

public abstract class Employee implements Serializable
{
	String name;
	String address;
	int age;
	boolean gender;
	float basicSalary;
	int allowance;
	
	
	
	public Employee(String name, String address, int age, boolean gender,
			float basicSalary, int allowance)
	{
		super();
		this.name = name;
		this.address = address;
		this.age = age;
		this.gender = gender;
		this.basicSalary = basicSalary;
		this.allowance = allowance;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public boolean isGender()
	{
		return gender;
	}
	public void setGender(boolean gender)
	{
		this.gender = gender;
	}
	public float getBasicSalary()
	{
		return basicSalary;
	}
	public void setBasicSalary(float basicSalary)
	{
		this.basicSalary = basicSalary;
	}
	public int getAllowance()
	{
		return allowance;
	}
	public void setAllowance(int allowance)
	{
		this.allowance = allowance;
	}
	
	

}
