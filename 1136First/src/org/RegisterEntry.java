package org;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

public class RegisterEntry 
{
	String userName;
	String password;
	String gender;
	String dob;
	
	
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public String getDob()
	{
		return dob;
	}
	public void setDob(String dob)
	{
		this.dob = dob;
	}
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
	
	
	public String execute()
	{ 
		Connection connection=null;
		PreparedStatement psInsert=null;
		
		try
		{
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@172.25.12.1:1521:orcl","user101","user101");
			psInsert=connection.prepareStatement("insert into MVCUsers values(?,?,?,?)");
			psInsert.setString(1, userName);
			psInsert.setString(2, password);
			psInsert.setString(3,gender);
			psInsert.setString(4, dob);
			
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
