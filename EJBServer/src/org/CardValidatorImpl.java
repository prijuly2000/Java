package org;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class CardValidatorImpl implements SessionBean
{
	
	
	private static final long serialVersionUID = 1L;

	public boolean validateCard(long cardNo,float amount) throws RemoteException	
	{
		System.out.println("Provided Card no:"+cardNo);
		if(cardNo==123 && amount<5000)
			return true;
		else
			return false;
	}
	
	public void ejbCreate()
	{
		
	}
	
	@Override
	public void ejbActivate() throws EJBException, RemoteException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ejbPassivate() throws EJBException, RemoteException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ejbRemove() throws EJBException, RemoteException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSessionContext(SessionContext arg0) throws EJBException,
			RemoteException
	{
		// TODO Auto-generated method stub
		
	}

	
}
