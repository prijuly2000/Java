package org;


import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;





public class Entry
{

	public static void main(String[] args)
	{
		try
		{
			CardsServiceLocator locater=new CardsServiceLocator();
			Cards remote=locater.getCards();
			boolean flag=remote.validateCard(12345, 152);
			System.out.println(flag);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ServiceException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
