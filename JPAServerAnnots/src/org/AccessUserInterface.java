package org;

import java.rmi.RemoteException;

import javax.ejb.Remote;


@Remote
public interface AccessUserInterface
{
	public void insertUser(String userName,String password,String name,String email)throws RemoteException;
	public String getPassword(String userName)throws RemoteException;
	public String getEmail(String userName)throws RemoteException;
	
	public String [] getAllEmails() throws RemoteException;
	public UserData getUserdata(String userName)throws RemoteException;

}
