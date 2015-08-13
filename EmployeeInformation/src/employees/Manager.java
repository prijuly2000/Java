package employees;

import java.io.Serializable;

public class Manager extends Employee implements Serializable
{
	float hra;

	public Manager(String name, String address, int age, boolean gender,
			float basicSalary,float hra, int allowance)
	{
		super(name, address, age, gender, basicSalary, allowance);

		this.hra=hra;
	}

	public float getHra()
	{
		return hra;
	}

	public void setHra(float hra)
	{
		this.hra = hra;
	}
	
	
	
	

}
