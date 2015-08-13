package pojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Admisson
{
	String name;
	String email;
	String clas;
	String mobile;
	
	
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


	public String getClas()
	{
		return clas;
	}


	public void setClas(String clas)
	{
		this.clas = clas;
	}


	public String getMobile()
	{
		return mobile;
	}


	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}


	public void save()
	{
		Connection connection=null;
		PreparedStatement psSelect=null;
		
		
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@172.25.12.1:1521:orcl","user101","user101");
			psSelect=connection.prepareStatement("insert into admission values(?,?,?,?)");
			psSelect.setString(1, name);
			psSelect.setString(2, email);
			psSelect.setString(3, clas);
			psSelect.setString(4, mobile);
			psSelect.executeUpdate();
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(psSelect!=null)
					psSelect.close();
				if(connection!=null)
					connection.close();
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
