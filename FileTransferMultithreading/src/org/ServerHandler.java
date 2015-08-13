package org;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHandler implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		ServerFrame frm=(ServerFrame)((Button)e.getSource()).getParent();
		String btnPressed=e.getActionCommand();
		
		ServerSocket server=null;
		DataOutputStream dos=null;
		OutputStream os=null;
		Socket client=null;
		DataInputStream dis=null;
		if(btnPressed.equals("Start"))
		{
			try
			{
				System.out.println("Server starting....");
				server=new ServerSocket(Integer.parseInt(frm.txtFields[0].getText()));
				System.out.println("server started....");
				client=server.accept();
				frm.txtClients.append(client.getRemoteSocketAddress().toString());
				File objFile=new File("D:\\nt-pritz\\javase\\FileTransferMultithreading\\images");
				String []fileNames=objFile.list();
				
				os=client.getOutputStream();
				dos=new DataOutputStream(os);
				dos.writeInt(fileNames.length);
				for(String file :fileNames)
				{
					dos.writeUTF(file);
				}
				
				InputStream is=client.getInputStream();
				dis=new DataInputStream(is);
				String sendFile=dis.readUTF();
				File sendFileLocation=new File("D:\\nt-pritz\\javase\\FileTransferMultithreading\\images\\"+sendFile);
				Thread.sleep(100);;
				byte []data=new byte[(int)sendFileLocation.length()];
				dos.writeInt(data.length);
				dos.write(data);	
				Thread.sleep(100);
				System.out.println("Sent to the client");
				
			} 
			catch (IOException | InterruptedException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		else if(btnPressed.equals("Stop"))
		{
			try
			{
				if(dos!=null)
					dos.close();
				if(os!=null)
					os.close();
				if(client!=null)
					client.close();
				if(server!=null)
					server.close();
				
				System.out.println("Server stopped....");
			} catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	

}
