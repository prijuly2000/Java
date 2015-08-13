package org;

public class JetEngine implements Engine
{
	String fuelType;
	
	public String getFuelType()
	{
		return fuelType;
	}

	public void setFuelType(String fuelType)
	{
		this.fuelType = fuelType;
	}

	@Override
	public void start()
	{
		System.out.println("JetPlane Started");

	}

	@Override
	public void stop()
	{
		System.out.println("JetPlane Stopped");

	}

	@Override
	public void fullThrottle()
	{
		System.out.println("full throttle");

	}

}
