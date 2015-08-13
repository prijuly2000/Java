package org;

public class Incrementor implements Runnable
{

	@Override
	public void run()
	{
		
		try
		{
			while(true)
			{
				synchronized (Entry.objData)
				{
					System.out.println(Entry.objData.value++);
				}
				Thread.sleep(100);
			}
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
