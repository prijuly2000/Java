import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class User
{
	String userName;
	String password;
	String name;
	String email;
	public void save()
	{
		Connection connection=null;
		PreparedStatement psSelect=null;
		ResultSet result=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@172.25.12.1:1521:orcl","user101","user101");
			psSelect=connection.prepareStatement("select * from users where userName=? and password=?");
			
			psSelect.setString(1,userName);
			psSelect.setString(2,password);
			
			psSelect.setString(3, name);
			psSelect.setString(4, email);
			
            psSelect.executeUpdate();
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
				if(connection!=null)
					connection.close();
				if(psSelect!=null)
					psSelect.close();
				if(result!=null)
					result.close();
			}
			catch (SQLException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
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
	
	

}
