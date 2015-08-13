package org;

import java.rmi.RemoteException;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Entry
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Properties props=new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		
		try
		{
			InitialContext ctx=new InitialContext(props);
			CardValidator remote=(CardValidator)ctx.lookup("Cards/remote");
			
			boolean status=remote.validateCard(12, 100);
			if(status)
				System.out.println("Card Accepted");
			else
				System.out.println("Card NOT Accepted");
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NamingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
