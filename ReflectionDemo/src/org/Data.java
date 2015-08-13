package org;

public class Data
{
	@SerialInfo(name="nt")
	public int id=1;
	public String name="Hello";
	@Override
	public String toString()
	{
		return name+id;
	}
	@SerialInfo(version=2,name="Display")
	public void display()
	{
		System.out.println("Display fired..");
	}
}
