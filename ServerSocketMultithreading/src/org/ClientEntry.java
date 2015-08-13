package org;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientEntry implements Runnable
{

	Socket client;
	public ClientEntry()
	{
		this.client=client;	
	}
	@Override
	public void run()
	{
		DataOutputStream dos=null;
		
		OutputStream os=client.getOutputStream();
		dos=new DataOutputStream(os);
		
		
		
		
	}
	
	
	

}
