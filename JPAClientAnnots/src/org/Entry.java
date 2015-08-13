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
		try
		{
			Properties props=new Properties();
			props.setProperty(InitialContext.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			props.setProperty(InitialContext.PROVIDER_URL, "jnp://localhost:1099");
			
			InitialContext ctx=new InitialContext(props);
			AccessUserInterface remote=(AccessUserInterface)ctx.lookup("AccessUserInterface/remote");
			System.out.println("inserted");
			//Make sure the username entry is unique in the table or the exception will occur
			//remote.insertUser("NT", "PRITZ", "nt", "pritz");
			
			/*String email=remote.getEmail("NT");
			System.out.println(remote.getPassword("NT"));
			System.out.println(email);
			*/
			
			String data[]=remote.getAllEmails();
			for(String info:data)
				System.out.println(info);
			System.out.println("/////////////");
			
			
			UserData objData=remote.getUserdata("NT");
			System.out.println(objData.getPassword());
			System.out.println(objData.getEmail());
			System.out.println(objData.name);
			
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
