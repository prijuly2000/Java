package org;

import java.util.Properties;
import java.util.Scanner;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Entry
{
	public static void main(String[] args)
	{
		QueueConnection connection=null;
		QueueSession session=null;
		QueueSender sender=null;
		
		try
		{
			Properties props=new Properties();
			props.setProperty(InitialContext.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			props.setProperty(InitialContext.PROVIDER_URL, "jnp://localhost:1099");
			InitialContext ctx =new InitialContext(props);
			QueueConnectionFactory factory=(QueueConnectionFactory)ctx.lookup("ConnectionFactory");
			connection=factory.createQueueConnection();
			session=connection.createQueueSession(false,QueueSession.AUTO_ACKNOWLEDGE);
			ObjectMessage msg=session.createObjectMessage();
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter Email");
			String to=scanner.next();
			
			System.out.println("Enter Message");
			String message=scanner.next();
			
			System.out.println("Enter CC");
			String cc=scanner.next();
			
			System.out.println("Enter Subject");
			String subject=scanner.next();
			
			MailData data=new MailData(to,cc,subject,message);
			msg.setObject(data);
			Queue queue=(Queue)ctx.lookup("/queue/NTMailQueue");
			
			sender=session.createSender(queue);
			sender.send(msg);
						
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
				if(session!=null)
					session.close();
				if(sender!=null)
					sender.close();
				if(connection!=null)
					connection.close();
			}
			catch (JMSException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
