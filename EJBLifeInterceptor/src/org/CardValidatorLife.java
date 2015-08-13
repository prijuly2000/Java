package org;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.interceptor.InvocationContext;

public class CardValidatorLife
{
	@PostConstruct
	public void init(InvocationContext ctx)
	{
		System.out.println("Init called");
	}
	
	@PreDestroy
	public void destroy()
	{
		System.out.println("destroy called");
	}
	
	@PrePassivate
	public void passivate(InvocationContext ctx)
	{
		System.out.println("Passivate called");
	}
	
	@PostActivate
	public void activate(InvocationContext ctx)
	{
		System.out.println("Activate done");
	}

}
