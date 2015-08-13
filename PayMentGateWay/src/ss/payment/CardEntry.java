package ss.payment;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;



public class CardEntry
{

	public static void main(String[] args)
	{
		
		try
		{
			System.out.println("Initializing server");
			CardImpl cvi;
			cvi = new CardImpl();
			Naming.bind("Cards",cvi);
			System.out.println("Server register & Please wait");
		}
		catch (RemoteException | MalformedURLException | AlreadyBoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
