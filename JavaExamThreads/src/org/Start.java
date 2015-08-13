package org;

public class Start
{
	FirstThread objThread1=new FirstThread();
	SecondThread objThread2=new SecondThread();
	ThirdThread objThread3=new ThirdThread();
	
	Thread t1=new Thread(objThread1);
	Thread t2=new Thread(objThread2);
	Thread t3=new Thread(objThread3);
	
	public void start()
	{
		try
		{
			t1.start();
			t1.sleep(1200);
			
			t2.start();
			t2.sleep(1200);
			
			t3.start();
			t3.sleep(1200);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
