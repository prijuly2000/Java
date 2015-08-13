package org;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface CardValidatorHome extends EJBHome
{
	public CardValidator create() throws RemoteException,CreateException;
	

}
