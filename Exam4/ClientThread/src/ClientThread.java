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
		
			client=new Socket("127.0.0.1",700);
			String data;
			is=client.getInputStream();
			dis=new DataInputStream(is); 
			int limit=dis.readInt();
			for(int index=0;index<limit;index++)
			{
				data=dis.readUTF();
				System.out.println(data);
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
