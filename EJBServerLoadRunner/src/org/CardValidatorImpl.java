package org;

import java.rmi.RemoteException;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

@Stateful(name="Cards")
@Remote(CardValidator.class)
public class CardValidatorImpl implements CardValidator
{

	long cardNo;
	@Override
	public boolean validateCard(long cardNo) throws RemoteException
	{
		this.cardNo=cardNo;
		System.out.println("Card no"+cardNo);
		return true;
	}

	@Override
	public long transact(float amount) throws RemoteException
	{
		
		return cardNo;
	}

	/**
	 * @param args
	 */
	

}
