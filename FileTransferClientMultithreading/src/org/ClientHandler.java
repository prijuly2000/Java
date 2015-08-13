package org;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientHandler implements ActionListener
{
	Socket client=null;
	InputStream is=null;
	DataInputStream dis=null;
	DataOutputStream dos=null;
	OutputStream os=null;

	@Override
	public void actionPerformed(ActionEvent e)
	{
		ClientFrame frm=(ClientFrame)((Button)e.getSource()).getParent();
		String actionCommand=e.getActionCommand();
		
		
		if(actionCommand.equals("Connect"))
		{
			try
			{
				System.out.println("client connecting..");
				client=new Socket(frm.txtFields[0].getText(),Integer.parseInt(frm.txtFields[1].getText()));
				System.out.println("connected...");
				is=client.getInputStream();
				dis=new DataInputStream(is);
				int limit=dis.readInt();
				for(int index=0;index<limit;index++)
				{
					frm.lstFiles.add(dis.readUTF());				
				}
			} catch (UnknownHostException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
					
			
		}
		else if(actionCommand.equals("Disconnect"))
		{
			try
			{
				if(dis!=null)
					dis.close();
				if(is!=null)
					is.close();
				if(client!=null)
					client.close();
			} catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		else
		{
			try
			{
				os=client.getOutputStream();
				dos=new DataOutputStream(os);
				
				String downloadFile=frm.lstFiles.getSelectedItem();
				dos.writeUTF(downloadFile);
				int limit=dis.readInt();
				byte []data=new byte[limit];
				dis.read(data);
				
				File download=new File("D:\\"+frm.lstFiles.getSelectedItem());
				if(!download.exists())
					download.createNewFile();
				FileOutputStream fos=new FileOutputStream(download);
				fos.write(data);
				Thread.sleep(100);
				System.out.println("Downloaded on client");
			} catch (IOException | InterruptedException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		
	}
	

}
