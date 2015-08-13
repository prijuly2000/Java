package employees;

import java.io.Serializable;

public class SalesPerson extends Employee implements Serializable
{
	float commission;

	public SalesPerson(String name, String address, int age, boolean gender,
			float basicSalary,float commission, int allowance )
	{
		super(name, address, age, gender, basicSalary, allowance);
		this.commission=commission;
	}

	public float getCommission()
	{
		return commission;
	}

	public void setCommission(float commission)
	{
		this.commission = commission;
	}
	
	
	

}
