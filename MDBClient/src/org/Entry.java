package org;

import java.util.Date;
import java.util.Properties;


import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Entry
{
	public static void main(String[] args)
	{
		QueueSender sender=null;
		QueueConnection connection=null;
		QueueSession session=null;
		
		Properties props=new Properties();
		props.setProperty(InitialContext.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		props.setProperty(InitialContext.PROVIDER_URL, "jnp://localhost:1099");
		
		try
		{
			InitialContext ctx=new InitialContext(props);
			QueueConnectionFactory factory=(QueueConnectionFactory) ctx.lookup("ConnectionFactory");
			connection=factory.createQueueConnection();
			
			session=connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			TextMessage txtMsg=session.createTextMessage();
			txtMsg.setText("This is User101 "+new Date());
			
			Queue queue=(Queue)ctx.lookup("/queue/FirstQueue");
			sender=session.createSender(queue);
			sender.send(txtMsg);
			System.out.println("Msg Delivered");
		}
		catch (NamingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (JMSException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(connection!=null)
					connection.close();
				if(sender!=null)
					sender.close();
				if(session!=null)
					session.close();
			}
			catch (JMSException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
