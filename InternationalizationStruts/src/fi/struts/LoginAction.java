package fi.struts;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport
{
	String userName;
	String password;
	
	/*@Override
	public void validate()
	{
		if(userName.length()<4)
			addFieldError("userName", getText("error.username.minlength"));
		else if(userName.length()>10)
			addFieldError("userName", getText("error.username.maxlength"));
		
		if(password.length()<4)
			addFieldError("password", getText("error.password.minlength"));
		else if(password.length()>10)
			addFieldError("password", getText("error.password.maxlength"));
	}*/
	
	
	
	@Override
	public String execute()
	{
		
		if(password.equals("user101") && userName.equals("user101"))
			return "success";
		else
			return "fail";
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
