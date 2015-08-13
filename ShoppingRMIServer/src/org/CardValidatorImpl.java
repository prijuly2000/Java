package org;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

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
			psSelect=connection.prepareStatement("select * from shoppingcards where cardNo=?");
			/*psInsert=connection.prepareStatement("insert into transactions values(?,?,?)");*/
			psUpdate=connection.prepareStatement("update shoppingcards set balance=? where cardNo=?");
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
	public boolean validateCard(long cardNo,String name,Date expiry,int cvv,float amount)
			throws RemoteException
	{
		ResultSet result=null;
		
		try
		{
			psSelect.setLong(1, cardNo);
			result=psSelect.executeQuery();
			if(result.next())
			{
				
				System.out.println("valid card no");
				float dbBalance=result.getFloat("balance");
				System.out.println(dbBalance);
				String dbName=result.getString("name");
				//Date dbDate=result.getDate("expiry");
				int dbCvv=result.getInt("cvv");
				
				//int dbMonth=dbDate.getMonth();
				//int dbYear=dbDate.getYear();
				//if(dbMonth==expiry.getMonth() && dbYear==expiry.getYear() && dbBalance>amount && dbName.equals(name)&& dbCvv==cvv)
				if( dbBalance>amount && dbName.equals(name)&& dbCvv==cvv)
				{
					dbBalance-=amount;
					System.out.println(dbBalance);
					psUpdate.setFloat(1, dbBalance);
					psUpdate.setLong(2, cardNo);
					psUpdate.executeUpdate();
					
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
