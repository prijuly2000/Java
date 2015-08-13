package employees;

import java.io.Serializable;

public class Engineer extends Employee implements Serializable
{
	float ot;

	public Engineer(String name, String address, int age, boolean gender,
			float basicSalary,float ot, int allowance)
	{
		super(name, address, age, gender, basicSalary, allowance);
		this.ot=ot;
		
	}

	public float getOt()
	{
		return ot;
	}

	public void setOt(float ot)
	{
		this.ot = ot;
	}
	
	
	
	

}
