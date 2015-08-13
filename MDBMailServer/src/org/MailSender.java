package org;

import java.util.Date;
import java.util.Properties;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

@MessageDriven(name="MailMDB",
		activationConfig={
		@ActivationConfigProperty(propertyName="destination",propertyValue="queue/NTMailQueue"),
		@ActivationConfigProperty(propertyName="destinationType",propertyValue="javax.jms.Queue"),
		@ActivationConfigProperty(propertyName="acknowledgeMode",propertyValue="auto-acknowledge")
		
})

public class MailSender implements MessageListener
{

	@Override
	public void onMessage(Message arg0)
	{
		if(arg0 instanceof ObjectMessage)
		{
			try
			{
				ObjectMessage msg=(ObjectMessage)arg0;
				MailData data=(MailData)msg.getObject();
				
				Properties mailProps=new Properties();
				mailProps.setProperty("mail.smtp.host", "smtp.gmail.com");
				mailProps.setProperty("mail.smtp.port", "587");
				mailProps.setProperty("mail.smtp.auth", "true");
				mailProps.setProperty("mail.smtp.starttls.enable", "true");
				Session session=Session.getInstance(mailProps,new AuthenticatorImpl());
				MimeMessage email=new MimeMessage(session);
				email.setSubject(data.getSubject());
				email.setContent(data.getMsg(),"text/html");
				email.addFrom(new InternetAddress[]
						{
							new InternetAddress("iacsd101@gmail.com")
						
						});
				email.addRecipient(RecipientType.TO, new InternetAddress(data.getTo()));
				
				if(data.getCc()!=null || data.getCc().length()>5)
					email.addRecipient(RecipientType.CC, new InternetAddress(data.getCc()));
					Transport.send(email);
					System.out.println("Message delivered at"+new Date());
			}
			catch (AddressException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (JMSException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (MessagingException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
