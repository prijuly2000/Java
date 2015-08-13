package org;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class CardEntry
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			System.out.println("Initializing server");
			CardValidatorImpl cvi=new CardValidatorImpl();
			Naming.bind("Cards",cvi);
			System.out.println("service registered");
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
