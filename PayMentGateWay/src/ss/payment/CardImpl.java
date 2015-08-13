package ss.payment;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class CardImpl extends UnicastRemoteObject implements Card
{
	protected CardImpl() throws RemoteException
	{
		super();
		// TODO Auto-generated constructor stub
	}
	Connection connection=null;
	PreparedStatement psSelect=null;
	PreparedStatement psUpdate=null;
	ResultSet result=null;
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean makePayment(long cardNo,String name,Date expiry,int cvv,double amount)throws RemoteException
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@172.25.12.1:1521:orcl","user102","user102");
			
			psSelect = connection.prepareStatement("select cardNo,balance from card where cardNo=?");
			psSelect.setLong(1, cardNo);
			result=psSelect.executeQuery();
			
			if(result.next())
			{
				float dbBalance=result.getFloat("balance");
				String dbName=result.getString("name");
				Date dbDate=result.getDate("expiry");
				int dbCvv=result.getInt("cvv");
				
				int dbMonth=dbDate.getMonth();
				int dbYear=dbDate.getYear();
				if(dbMonth==expiry.getMonth() && dbYear==expiry.getYear() && dbBalance>amount && dbName.equals(name)&& dbCvv==cvv )
				{
					dbBalance-=amount;
					psUpdate=connection.prepareStatement("Update card set balance=? where cardNo=?");
					psUpdate.setFloat(1, dbBalance);
					psUpdate.setLong(2, cardNo);
					psUpdate.executeUpdate();
							
					return true;
				}
				
			}
			
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
		
		return false;
	}

}
