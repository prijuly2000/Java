package org;

public class SecondThread implements Runnable
{

	@Override
	public void run()
	{
		while(true)
		{
			try
			{
				System.out.println("second thread running");
				Thread.sleep(500);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
