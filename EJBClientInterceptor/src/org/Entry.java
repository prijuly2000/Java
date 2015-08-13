package org;

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
		try
		{
			Properties prps=new Properties();
			prps.setProperty(InitialContext.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			prps.setProperty(InitialContext.PROVIDER_URL, "jnp://localhost:1099");
			
			InitialContext ctx=new InitialContext(prps);
			for(int iTmp=1000;iTmp<1050;iTmp++)
			{
				LoadRunner runner=new LoadRunner(ctx,iTmp);
				Thread objThread=new Thread(runner);
				objThread.start();
			}
		}
		catch (NamingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
