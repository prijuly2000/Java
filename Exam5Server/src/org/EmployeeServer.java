package org;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeServer extends UnicastRemoteObject implements Employee
{

	protected EmployeeServer() throws RemoteException
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@172.25.12.1:1521:orcl","user101","user101");
			psNames=connection.prepareStatement("select name from Employ");
			psDetails=connection.prepareStatement("select * from Employ where name=?");
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	Connection connection=null;
	PreparedStatement psNames=null;
	PreparedStatement psDetails=null;
	
	@Override
	public String[] getAllEmployeeNames() throws RemoteException
	{
		String []empNames=new String [10];		
		ResultSet result=null;
		
		try
		{
			result=psNames.executeQuery();
			int index=0;
			while(result.next())
			{
				empNames[index]=result.getString("name");
				index++;
			}
			return empNames;
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;	
	}

	@Override
	public String[] getEmployeeDetails(String name) throws RemoteException
	{
		ResultSet result=null;
		String details[]=new String[3];
		
		try
		{
			if(name!=null)
			{
				psDetails.setString(1, name);
				result=psDetails.executeQuery();
				
				details[0]=result.getString("name");
				details[1]=result.getString("addr");
				details[2]=result.getString("qual");
				return details;
				
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  null;
		
		
	}

	@Override
	public boolean registerEmployee() throws RemoteException
	{
		
		return false;
	}

}
