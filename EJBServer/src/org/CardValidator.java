package org;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface CardValidator extends EJBObject
{
	public boolean validateCard(long cardNo,float amount) throws RemoteException;
}
