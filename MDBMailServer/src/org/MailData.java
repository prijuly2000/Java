package org;

import java.io.Serializable;

public class MailData implements Serializable
{
	String to;
	String cc;
	String subject;
	String msg;
	public String getTo()
	{
		return to;
	}
	public void setTo(String to)
	{
		this.to = to;
	}
	public String getCc()
	{
		return cc;
	}
	public void setCc(String cc)
	{
		this.cc = cc;
	}
	public String getSubject()
	{
		return subject;
	}
	public void setSubject(String subject)
	{
		this.subject = subject;
	}
	public String getMsg()
	{
		return msg;
	}
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
	public MailData(String to, String cc, String subject, String msg)
	{
		super();
		this.to = to;
		this.cc = cc;
		this.subject = subject;
		this.msg = msg;
	}
	
	public MailData()
	{}

}
