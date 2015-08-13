package org;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionHandler implements HttpSessionListener
{

	@Override
	public void sessionCreated(HttpSessionEvent arg0)
	{
		HttpSession session=arg0.getSession();
		System.out.println("Session created "+session.getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0)
	{
		HttpSession session=arg0.getSession();
		System.out.println("session destroyed for "+session.getId());
	}

}
