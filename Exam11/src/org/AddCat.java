package org;

import com.opensymphony.xwork2.ActionSupport;

public class AddCat extends ActionSupport
{
	public String execute()
	{
		System.out.println("AddCat Execute fired...");
		return "success";
		
	}

}
