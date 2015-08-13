package org;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Entry
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
			try
			{
				Class refClass=Class.forName(args[0]);
				Field arrField[]=refClass.getFields();
				Field arrFieldNames[]=refClass.getDeclaredFields(); 

				for(Field field :arrField)
				{
					
					System.out.println(field.getName());
				}
				for(Field name :arrFieldNames)
				{
					System.out.println(name);
				}
				
				Method []arrMethodName=refClass.getMethods();
				for(Method method : arrMethodName)
				{
					System.out.println(method.getName());
				}
				
				Object obj=refClass.newInstance();
				Field objField=refClass.getField("name");
				objField.set(obj, "What the hell!!!");
				
			
				
				Method objMethod=refClass.getMethod("display", null);
				objMethod.invoke(obj, null);
				System.out.println("Data of Emp:"+obj);
				Annotation []arrAnnots=objMethod.getAnnotations();
				for(Annotation objAnnot :arrAnnots)
				{
					if(objAnnot instanceof SerialInfo)
					{
						SerialInfo info=(SerialInfo)objAnnot;
						System.out.println("Annot Name:"+info.name());
						System.out.println("Annot Version:"+info.version());
					}
				}
				
			} catch (ClassNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
