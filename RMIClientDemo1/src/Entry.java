
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import org.CardValidator;




public class Entry
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			CardValidator cv=(CardValidator)Naming.lookup("rmi://172.25.12.148/Cards");
			
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter the cardNo");
			long cardNo=scanner.nextLong();
			System.out.println("Enter the amount");
			float amount=scanner.nextFloat();
			
			boolean flag=cv.validateCard(cardNo,amount);
			if(flag)
			{
				System.out.println("Card Accepted");
			}
			else
			{
				System.out.println("Card Declined");
			}
		} catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
