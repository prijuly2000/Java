package org;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.print.attribute.standard.Severity;

public class ServerEntry
{

	/**
	 * @param args
	 */
	//for send & receive string only
	public static void main1(String[] args)
	{
		ServerSocket server=null;
		
		try
		{
			
			server=new ServerSocket(3000);
			
			while (true)
			{
				System.out.println("Waiting for conection...");
				Socket client = server.accept();
				System.out.println("Client connected from "
						+ client.getRemoteSocketAddress());
				OutputStream os = client.getOutputStream();
				os.write("Welcome To pritz-nt Server".getBytes());
				InputStream is = client.getInputStream();
				byte[] data = new byte[100];
				is.read(data);
				String input = new String(data);
				System.out.println("Client Message : " + input);
			}
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(server!=null)
					server.close();
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
		ServerSocket server=null;
		DataOutputStream dos=null;
		DataInputStream dis=null;
		
		try
		{
			server = new ServerSocket(4000);
			while (true)
			{
				
				System.out.println("waiting for connection");
				client = server.accept();
				System.out.println("client connected from"
						+ client.getRemoteSocketAddress());
				OutputStream os = client.getOutputStream();
				dos = new DataOutputStream(os);
				dos.writeUTF("Welcome to server...have fun...");
				InputStream is = client.getInputStream();
				dis = new DataInputStream(is);
				String data = dis.readUTF();
				System.out.println(data);
			}
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(dos!=null)
					dos.close();
				
				if(dis!=null)
					dis.close();
				if(server!=null)
					server.close();
				
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
