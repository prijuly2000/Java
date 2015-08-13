package org;

public class Entry
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Start obj=new Start();
		obj.start();
		
		while(true)
		{
			try
			{
				Thread.sleep(1000);
				System.out.println("Main Thread");
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
