package org;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterEntry
{
	String userName;
	String password;
	String name;
	String email;
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String execute()
	{ 
		Connection connection=null;
		PreparedStatement psInsert=null;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@172.25.12.1:1521:orcl","user101","user101");
			psInsert=connection.prepareStatement("insert into Users values(?,?,?,?)");
			psInsert.setString(1, userName);
			psInsert.setString(2, password);
			psInsert.setString(3, name);
			psInsert.setString(4, email);
			
			psInsert.executeUpdate();
			return ("success");
			
				
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
				if(psInsert!=null)
					psInsert.close();
				if(connection!=null)
					connection.close();
				
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ("failure");
	}
}
