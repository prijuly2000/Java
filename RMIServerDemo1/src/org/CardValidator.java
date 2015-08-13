package org;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CardValidator extends Remote
{
	public boolean validateCard(long cardNo,float amount) throws RemoteException;
}
