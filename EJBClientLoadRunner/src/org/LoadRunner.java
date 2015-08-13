package org;

import java.rmi.RemoteException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class LoadRunner implements Runnable
{

	InitialContext ctx;
	long cardNo;
	
	
	
	public LoadRunner(InitialContext ctx, long cardNo)
	{
		super();
		this.ctx = ctx;
		this.cardNo = cardNo;
	}



	@Override
	
	public void run()
	{
		try
		{
			CardValidator remote=(CardValidator)ctx.lookup("Cards/remote");
			boolean status=remote.validateCard(cardNo);
			Thread.sleep(500);
			long cNo=remote.transact(123);
			System.out.println("Send:"+cardNo+" received:"+cNo);
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
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
