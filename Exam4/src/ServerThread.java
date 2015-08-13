import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.Frame;



public class ServerThread 
{
	public ServerThread()
	{
		ServerSocket server=null;
		DataOutputStream dos=null;
		Socket client=null;
		
		OutputStream os=null;
		
		try 
		{
			Method methods[]=Class.forName("java.awt.Frame").getMethods();
			
		
			server=new ServerSocket(3000);
			while(true)
			{
				client=server.accept();
				System.out.println("connected to client");
				Thread objThread=new Thread(new NewThread(client));
				objThread.start();
							
			}
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(dos!=null)
					dos.close();
				if(os!=null)
					os.close();
				if(server!=null)
					server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
