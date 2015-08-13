package org;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Entry
{

	FileInputStream fis1=null;
	FileInputStream fis2=null;
	FileOutputStream fos=null;
	FileInputStream fis3=null;
	byte []arrByte2=null;
	byte []arrByte1=null;
	File file3=null;
	File file1=null;
	File file2=null;
	/**
	 * @param args
	 */
	
	public static void main(String[] args)
	{
		Entry entry=new Entry();
		
		String choice="y";
		
		
		while(choice.equals("y")|| choice.equals("Y"))
		{
			System.out.println("---Menu---");
			System.out.println("1.Display file1 ");
			System.out.println("2.Read console And write to file2");
			System.out.println("3.file1 + file2 => file3");
			System.out.println("Enter the choice:");
			Scanner scan=new Scanner(System.in);
			switch(scan.next())
			{
			case "1":
				entry.displayFile();
				break;
			case "2":
				entry.writeFile();
				break;
			case "3":
				entry.writeFile3();
				break;
			}
			System.out.println("Wanna conti?(y/n)");
			choice=scan.next();
			
		}
		
		
	}
	
	public void writeFile3()
	{
		file1=new File("d:\\file1.txt");
		file2=new File("d:\\file2.txt");
		
		try
		{
			fis1 =new FileInputStream(file1);
			fis2=new FileInputStream(file2);
			
			arrByte1=new byte[(int)file1.length()];
			arrByte2=new byte[(int)file2.length()];
			
			fis1.read(arrByte1);
			fis2.read(arrByte2);
			
			String dataFile1=new String(arrByte1);
			String dataFile2=new String(arrByte2);
			
			String dataFile="";
			
			file3=new File("d:\\file3.txt");
			if(!file3.exists())
				file3.createNewFile();
			else
			{
				fis3=new FileInputStream(file3);
				byte arrByte3[]=new byte[(int)file3.length()];
				String fileData3=new String(arrByte3);
				dataFile=fileData3+" ";
				System.out.println(dataFile);
				
				
			}
			dataFile+=dataFile1+dataFile2;
			System.out.println(dataFile);
			fos=new FileOutputStream(file3);
			
			
			char [] chrData=dataFile.toCharArray();
			int ln=dataFile.length();
			int count=0;
			
			for(char ch:chrData)
			{
				if((ch=='\n')||(ch==' '))
						count++;
			}
			count++;
			
			System.out.println("Word count: "+count);
			
			fos.write(dataFile.getBytes());
			System.out.println("file3 write complete...");
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
		finally
		{
			try
			{
				if(fis1!=null)
					fis1.close();
				if(fis2!=null)
					fos.close();
				if(fos!=null)
					fos.close();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void writeFile()
	{
		try
		{
			file2=new File("d:\\file2.txt");
			if(!file2.exists())
				file2.createNewFile();
			
			Scanner scan=new Scanner(System.in);
			fos=new FileOutputStream(file2);
			System.out.println("Enter the data to write : ");
			String data=scan.nextLine();
			fos.write(data.getBytes());
			System.out.println("File2 write Complete...");
			
			
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
		finally
		{
			try
			{
				if(fos!=null)
					fos.close();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void displayFile()
	{
		try
		{
			System.out.println("Enter the file to read:");
			Scanner scan=new Scanner(System.in);
			String str=""; 
			//str="d:\\file1.txt";
			str=scan.next();
			file1=new File(str);
			if(!file1.exists())
			{
				System.out.println("File does not exists");
				return;
			}
			else
			{
				fis1 =new FileInputStream(file1);
				
				arrByte1=new byte[(int)file1.length()];
				fis1.read(arrByte1);
				 System.out.println("-------------------");
				System.out.println("File data : ");
				String data=new String (arrByte1);
				System.out.println(data);
								
			}
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
		finally
		{
			try
			{
				if(fis1!=null)
					fis1.close();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		 System.out.println("-------------------");
		System.out.println("File1 display Complete...");
		
	}

}
