package org;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name="FirstMDB",
	activationConfig=
	{
		@ActivationConfigProperty (propertyName="destination", propertyValue="queue/FirstQueue"),
		@ActivationConfigProperty(propertyName="destinationType",propertyValue="javax.jms.Queue"),
		@ActivationConfigProperty(propertyName="acknowledgeMode",propertyValue="auto-acknowledge")
	})

public class MessageBean implements MessageListener
{

	@Override
	public void onMessage(Message msg)
	{
		if(msg instanceof TextMessage)
		{
			
			try
			{
				TextMessage txtMessage=(TextMessage)msg;
				String data=txtMessage.getText();
				System.out.println("Msg received "+data);
			}
			catch (JMSException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
