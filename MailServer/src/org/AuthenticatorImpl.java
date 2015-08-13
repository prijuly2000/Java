package org;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;



public class AuthenticatorImpl extends Authenticator
{

	@Override
	protected PasswordAuthentication getPasswordAuthentication()
	{
		return new PasswordAuthentication("iacsd101@gmail.com","neerajpritz");
	}
	
}
