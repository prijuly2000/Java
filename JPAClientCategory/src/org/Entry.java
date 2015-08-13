package org;

import java.rmi.RemoteException;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Entry
{

	
	public static void main(String[] args)
	{
	  try
	  {
		  Properties props=new Properties();
		  props.setProperty(InitialContext.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
		  props.setProperty(InitialContext.PROVIDER_URL, "jnp://localhost:1099");
		  InitialContext ctx=new InitialContext(props);
		  AccessCategory remote=(AccessCategory)ctx.lookup("AccessCategory/remote");
		 
		  System.out.println( remote.getCatName(1));
		  System.out.println(remote.getCatDesc(1));
		  System.out.println(remote.getCatImage(1));
	  }
		catch (NamingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		

	}

}
