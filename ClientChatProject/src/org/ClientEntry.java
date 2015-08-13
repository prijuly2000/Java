package org;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientEntry
{
	public static void main(String[] args)
	{
		String msg="";
		Socket client=null;
		DataOutputStream dos=null;
		DataInputStream dis=null;
		InputStream is=null;
		OutputStream os=null;
		
		try
		{
			System.out.println("Connecting...");
			client=new Socket("172.25.12.149",7000);
			System.out.println("Connected to the server...");
			
			os=client.getOutputStream();
			is=client.getInputStream();
			dos=new DataOutputStream(os);
			dis=new DataInputStream(is);
			Scanner scanner=new Scanner(System.in);
			System.out.println("Chatting Application Started....");
			String clientName="Pritz : > ";
			while(true)
			{
				System.out.println(dis.readUTF());
				
				dos.writeUTF(clientName+scanner.nextLine());
			}
			
		} catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	
		
	}
}
