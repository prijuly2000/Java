package org;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardValidatorImpl extends UnicastRemoteObject implements CardValidator
{
	Connection connection=null;
	PreparedStatement psSelect=null;
	PreparedStatement psInsert=null;
	PreparedStatement psUpdate=null;

	protected CardValidatorImpl() throws RemoteException
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@172.25.12.1:1521:orcl","user101","user101");
			psSelect=connection.prepareStatement("select * from cards where cardNo=?");
			psInsert=connection.prepareStatement("insert into transactions values(?,?,?)");
			psUpdate=connection.prepareStatement("update cards set balance=? where cardNo=?");
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean validateCard(long cardNo, float amount)
			throws RemoteException
	{
		ResultSet result=null;
		
		try
		{
			psSelect.setLong(1, cardNo);
			result=psSelect.executeQuery();
			if(result.next())
			{
				float balance=result.getFloat("balance");
				if(balance>=amount)
				{
					balance-=amount;
					psUpdate.setFloat(1, balance);
					psUpdate.setLong(2, cardNo);
					psUpdate.executeUpdate();
					
					psInsert.setLong(1, cardNo);
					psInsert.setFloat(2, amount);
					psInsert.setDate(3, new Date(System.currentTimeMillis()));
					psInsert.executeUpdate();
					return true;
				}
				
			}
			
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	

}
