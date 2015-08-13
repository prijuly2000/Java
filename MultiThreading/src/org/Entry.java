package org;

public class Entry
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		IncrementorThread inThread=new IncrementorThread();
		DecrementorThread dcThread=new DecrementorThread();
		
		inThread.start();
		
		Thread objThread=new Thread(dcThread);
		objThread.start();
		System.out.println("main function");
	}

}
