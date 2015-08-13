package org;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHandler 
{
	static ServerSocket server;
	static Socket client;
	public ServerHandler(Socket client2)
	{
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) 
	{
		try 
		{
			server = new ServerSocket(7200);
			while(true)
			{
				client = server.accept();
				ServerHandler objTarget= new ServerHandler(client);
				Thread objThread = new Thread(objTarget);
				objThread.setDaemon(true);
				objThread.start();
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
