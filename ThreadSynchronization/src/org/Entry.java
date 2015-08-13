package org;

public class Entry
{

	
	static Data objData=new Data();
	public static void main(String[] args)
	{
		Incrementor objIncrementor = new Incrementor();
		Thread incThread=new Thread(objIncrementor);
		incThread.start();
		
		
		Decrementor objDecrementor = new Decrementor();
		Thread decThread=new Thread(objDecrementor);
		decThread.start();
		
		
		

	}

}
