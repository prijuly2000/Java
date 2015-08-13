package org;

public class IncrementorThread extends Thread
{

	@Override
	public void run()
	{
		try
		{
			while(true)
			{
				System.out.println("Incrementor");
				Thread.sleep(50);
			}
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
