package org;

import java.rmi.RemoteException;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(CardValidator.class)
@Stateless(name="Cards")
public class CardValidatorImpl implements CardValidator
{

	@Override
	public boolean validateCard(long cardNo,float amount) throws RemoteException
	{
		
		System.out.println("Card No:"+cardNo);
		if(cardNo==12 && amount<3000)
			return true;
		else
			return false;
	}
	
}
