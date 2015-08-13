package org;

public class DecrementorThread implements Runnable
{

	@Override
	public void run()
	{
		try
		{
			while(true)
			{
				System.out.println("Decrementor");
				Thread.sleep(50);
			}
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
