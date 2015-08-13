package org;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Entry
{

	public static void main(String[] args)
	{
		try
		{
			System.out.println("Server started...");
			EmployeeServer empServer=new EmployeeServer();
			System.out.println("Service Registering...");
			Naming.bind("EmployeeDetails", empServer);
			System.out.println("Registered successfully...");
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (AlreadyBoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
