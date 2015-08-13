package org;

import java.rmi.RemoteException;

import javax.ejb.Remote;
@Remote
public interface CardValidator
{
	public boolean validateCard(long cardNo,float amount) throws RemoteException;
	//public long transact(float amount)throws RemoteException;
}
