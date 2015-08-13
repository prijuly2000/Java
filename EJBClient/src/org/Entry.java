package org;


import java.rmi.RemoteException;
import java.util.Properties;

import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public class Entry
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			Properties props=new Properties();
			props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
			props.setProperty("java.naming.provider.url", "jnp://localhost:1099");
			
			
			InitialContext ctx=new InitialContext(props);
			Object obj=ctx.lookup("Cards");
			
			CardValidatorHome home=(CardValidatorHome)PortableRemoteObject.narrow(obj, CardValidatorHome.class);
			CardValidator remote=home.create();
			
			boolean status=remote.validateCard(123, 5000);
			if(status)
				System.out.println("card accepted");
			else
				System.out.println("card declined");
		}
		catch (ClassCastException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		catch (CreateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
