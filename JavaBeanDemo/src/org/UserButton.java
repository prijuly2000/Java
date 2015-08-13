package org;

import java.awt.Button;
import java.awt.HeadlessException;

public class UserButton extends Button
{
	String caption;

	public UserButton() 
	{
		super();
		this.caption ="Stop";
	}

	public String getCaption()
	{
		return caption;
	}

	public void setCaption(String caption)
	{
		this.caption = caption;
		setLabel(caption);
		
	}
	
	

}
