package org;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Entry
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String data1=null;
		String data2=null;
		FileInputStream file1=null;
		FileInputStream  file2=null;
		FileOutputStream file3=null;
		
		File obj1=new File("d:\\file1.txt");
		File obj2=new File("d:\\file2.txt");
		
		try
		{
			file1=new FileInputStream(obj1);
			file2=new FileInputStream(obj2);
			
			byte []arrByte1=new byte[(int)obj1.length()];
			byte []arrByte2=new byte[(int)obj2.length()];
			file1.read(arrByte1);
			file2.read(arrByte2);
			data1=new String(arrByte1);
			data2=new String(arrByte2);
			data1+=data2;
			
			File obj3=new File("d:\\file3.txt");
			
			if(!obj3.exists())
				obj3.createNewFile();
			
			file3=new FileOutputStream(obj3);
			file3.write(data1.getBytes());
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
