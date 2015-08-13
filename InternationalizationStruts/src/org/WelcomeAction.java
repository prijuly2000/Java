package org;

import com.opensymphony.xwork2.ActionSupport;

public class WelcomeAction extends ActionSupport
{

	@Override
	public String execute() throws Exception
	{
		System.out.println("WelcomeAction Execute called");
		return "success";
	}
	

}
