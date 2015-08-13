package org;

import java.rmi.RemoteException;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;

//@Stateful(name="Cards")
@Singleton(name="Cards")
@Remote(CardValidator.class)
@Interceptors(CardValidatorLife.class)
public class CardValidatorImpl implements CardValidator
{
	long cardNo;

	@Override
	public boolean validateCard(long cardNo) throws RemoteException
	{
		this.cardNo=cardNo;
		System.out.println("Card No "+cardNo);
		return true;
	}

	@Override
	public long transact(float amount) throws RemoteException
	{
		
		return cardNo;
	}
	
}
