package org;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;

public interface CardValidator extends Remote
{
	public boolean validateCard(long cardNo,String name,Date expiry,int cvv,float amount) throws RemoteException;

}
