package org;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientEntry
{

	/**
	 * @param args
	 */
	//for send & receive string only
	public static void main1(String[] args)
	{
		Socket client=null;
		
		try
		{
			client=new Socket("localhost",3000);
			System.out.println("Connection established....");
			InputStream is= client.getInputStream();
			byte []data=new byte[100];
			is.read(data);
			String input=new String(data);
			System.out.println("Server mesage: "+input);
			
			OutputStream os=client.getOutputStream();
			os.write("Thank you for allowing".getBytes());
			
		} catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(client!=null)
					client.close();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	
	public static void main(String[] args)
	{
		Socket client=null;
		DataOutputStream dos= null;
		DataInputStream dis=null;
		
		
		
		try
		{
			System.out.println("connecting to the server...please wait");
			client= new Socket("172.25.12.149",3000);
			System.out.println("connected to the server");
			InputStream is=client.getInputStream();
			dis= new DataInputStream(is);
			String data=dis.readUTF();
			System.out.println("server message:"+data);
			OutputStream os=client.getOutputStream();
			dos=new DataOutputStream(os);
			dos.writeUTF("This is nt-pritz.");
		} catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(dis!=null)
					dis.close();
				if(dos!=null)
					dos.close();
				
				if(client!=null)
					client.close();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
	
		
	}
}
