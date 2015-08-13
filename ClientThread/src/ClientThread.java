import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClientThread 
{
	
	public ClientThread()
	{
		Socket client=null;
		DataInputStream dis=null;
		InputStream is=null;
		
		try 
		{
			System.out.println("connecting...");
		
			client=new Socket("localhost",3000);
			System.out.println("connected");
			//client=new Socket("127.0.0.1",7000);
			String data;
			is=client.getInputStream();
			dis=new DataInputStream(is); 
			int limit=dis.readInt();
			try
			{
				for(int index=0;index<limit;index++)
				{
					data=dis.readUTF();
					System.out.println(data);
					Thread.sleep(1000);
				}
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		catch (UnknownHostException e) 
		{
			// TODO Auto-generated catch block
			
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			
		}
		finally
		{
			try 
			{
				if(dis!=null)
					dis.close();
				if(is!=null)
					is.close();
				
				if(client!=null)
					client.close();
			}
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
			
			}
		}
		
	}

}
