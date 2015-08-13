package org;

import java.rmi.RemoteException;

import javax.ejb.Remote;

@Remote
public interface AccessCategory
{
	public void insertCategory(Integer catId,String catName,String catDesc,String catImage )throws RemoteException;
	public String getCatName(Integer catId)throws RemoteException;
	public String getCatImage(Integer catId)throws RemoteException;
	public String getCatDesc(Integer catId)throws RemoteException;
	

}
