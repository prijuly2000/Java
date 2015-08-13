package org;



import java.io.IOException;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClientEntry
{

	
	public static void main(String[] args)
	{
		Socket client=null;
		
		
		try
		{
			System.out.println("Connecting to server....");
			client=new Socket("localhost",7200);
			System.out.println("Connected to the server....");
			InputStream is=client.getInputStream();
			OutputStream os=client.getOutputStream();
			byte[]data=new byte[100];
			is.read(data);
			String str=new String(data);
			System.out.println(str);
			os.write("have Fun".getBytes());
		} catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	finally
	{
	try
	{
		if(client!=null)	
			client.close();
	} catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
		
		
		try {
			  Class refClass= Data.class;
			  Field[]arrField=refClass.getFields();
			  
			  for(Field objField:arrField)
			  {
				  System.out.println(objField.getName());
			  }
			  
			  Method[]arrMethod= refClass.getMethods();
			  
			  for(Method objMethod:arrMethod)
			  {
				  System.out.println(objMethod.getName());
			  }
			  
			  try {
				Object obj=refClass.newInstance();
				System.out.println(obj);
			} 
			  catch (InstantiationException e) {
				
				e.printStackTrace();
			} catch (IllegalAccessException e)
			{
			  e.printStackTrace();
			}
			  
		} catch (SecurityException e) {
			
			e.printStackTrace();
		}
	}

	}


