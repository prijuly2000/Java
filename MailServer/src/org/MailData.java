package org;

public class MailData
{
	String to;
	String cc;
	String msg;
	String subject;
	
	public MailData(){}

	public MailData(String to, String cc, String msg, String subject)
	{
		super();
		this.to = to;
		this.cc = cc;
		this.msg = msg;
		this.subject = subject;
	}

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

	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}
	
	
}
