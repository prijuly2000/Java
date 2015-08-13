package org;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ClientEntry
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			CardValidator cv=(CardValidator)Naming.lookup("rmi://localhost/cards");
			Scanner scaner=new Scanner(System.in);
			
			System.out.println("Enter CardNo:");
			long cardNo=scaner.nextLong();
			System.out.println("Enter amount");
			float amount=scaner.nextFloat();
			
			boolean flag=cv.validateCard(cardNo, amount);
			if(flag)
				System.out.println("card accepted");
			else
				System.out.println("card denied");
		} catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
