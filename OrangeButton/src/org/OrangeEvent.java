package org;

import java.util.EventObject;

public class OrangeEvent extends EventObject
{
	String message;
	public OrangeEvent(Object source,String msg)
	{
		super(source);
		this.message=msg;
	}
}
