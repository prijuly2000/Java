package org;

public class LoginAction
{
	String userName;
	String password;
	
	public String execute()
	{
		System.out.println("execute Fired....");
		if(userName.equals("user101") && password.equals("user101"))
		{
			return "success";
		}
		else
		{
			return "failure";
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
	
	

}
