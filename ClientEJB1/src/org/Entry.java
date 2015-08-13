package org;

import java.rmi.RemoteException;
import java.util.Properties;

import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public class Entry
{
	public static void main(String[] args)
	{
		try
		{
			Properties prop=new Properties();
			prop.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
			prop.setProperty("java.naming.provider.url", "jnp://localhost:1099");
			InitialContext ctx=new InitialContext(prop);
			Object obj=ctx.lookup("cards");
			CardValidatorHome home=(CardValidatorHome)PortableRemoteObject.narrow(obj,CardValidatorHome.class);
			CardValidator remote=home.create();
			boolean status=remote.validateCard(1234, 1234556783);
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
