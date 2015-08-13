package org;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CardValidatorImpl extends UnicastRemoteObject implements CardValidator
{

	protected CardValidatorImpl() throws RemoteException
	{
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validateCard(long cardNo, float amount)
			throws RemoteException
	{
		System.out.println("Validate cardn fired with"+cardNo+" and amount "+amount);
		if(cardNo==12345 && amount<5000)
			return true;
		else
			return false;
		
	}
	
}
