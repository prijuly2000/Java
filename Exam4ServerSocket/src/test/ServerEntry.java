


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEntry
{

	public static void main(String[] args)
	{
		ServerSocket server=null;
		
		try
		{
			System.out.println("Initlialize server port 2616" );
			server =new ServerSocket(7200);
			
			System.out.println("Waitng for Connection");
			Socket client=server.accept();
			System.out.println("Client Connected from"+client.getRemoteSocketAddress());
			OutputStream os=client.getOutputStream();
			os.write("Welcome to server... \nYour Class Function an data members are=".getBytes());
			InputStream is=client.getInputStream();
			byte[] data=new byte[100];
			is.read(data);
			System.out.println(new String(data));
			
		} 
		catch (IOException e)
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
	}




