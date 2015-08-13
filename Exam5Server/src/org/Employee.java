package org;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Employee extends Remote
{
	public String[] getAllEmployeeNames() throws RemoteException;
	public String[] getEmployeeDetails(String name) throws RemoteException;
	public boolean registerEmployee() throws RemoteException;
}
