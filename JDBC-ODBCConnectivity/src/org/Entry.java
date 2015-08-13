package org;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Entry
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Connection connection=null;
		Statement stSelect=null;
		ResultSet result=null;
	
		try
		{
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			connection=DriverManager.getConnection("jdbc:odbc:pritz");
			stSelect=connection.createStatement();
			result=stSelect.executeQuery("select * from Student");
			
			while(result.next())
			{
				System.out.println(result.getString(1));
				System.out.println(result.getString(2));
				System.out.println(result.getString(3));
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
		
		finally
		{
			try
			{
				if(result!=null)
				result.close();
				
				if(stSelect!=null)
					stSelect.close();
				if(connection!=null)
					connection.close();
			}
			catch (SQLException e)
			
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

 }

