import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.Socket;


public class NewThread implements Runnable{
	Socket client;
	public NewThread(Socket client)
	{
		this.client=client;
	}
	
		@Override
	public void run() {
		
			try 

			{
				Method methods[]=Class.forName("java.awt.Frame").getMethods();
				OutputStream os=null;
				DataOutputStream dos=null;
				os=client.getOutputStream();
				dos=new DataOutputStream(os);
				dos.writeInt(methods.length);
				for(int index=0;index<methods.length;index++)
				{
					dos.writeUTF(methods[index].getName());
					
				}
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	
		

}
