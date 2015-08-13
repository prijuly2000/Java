package org;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name="CardsLocal")
@Local(CardsLocal.class)
public class CardsImpl implements CardsLocal
{

	@Override
	public boolean validate(long cardNo, float amount)
	{
		System.out.println("local validate fired");
		return true;
	}

}
