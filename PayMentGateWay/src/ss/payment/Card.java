package ss.payment;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;

public interface Card extends Remote
{
	public boolean makePayment(long cardNo,String name,Date expiry,int cvv,double amount)throws RemoteException;
}
