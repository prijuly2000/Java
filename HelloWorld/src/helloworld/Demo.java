package helloworld;

import java.io.UTFDataFormatException;
import java.lang.Character.UnicodeBlock;

public class Demo
{

	/**
	 * @param args */
	public static void main(String[] args)
	{
		
		String str="\u00A1";
		System.out.println(str);
		
	System.out.println( "¢");
	}

}
