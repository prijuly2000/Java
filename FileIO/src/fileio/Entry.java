package fileio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import javax.xml.crypto.Data;

public class Entry
{

	/**
	 * @param args
	 */
	public static void main1(String[] args)
	{
		File objFile=new File("D:\\nt-pritz\\javase\\FileIO\\images");
		File []arrFiles=objFile.listFiles();
		for(File file:arrFiles)
		{
			System.out.println(file.getName());
			System.out.println(new Date(file.lastModified()));
			System.out.println(file.length()/1024);
			System.out.println("************");
			
			
			
		}

	}

	
	public static void main2(String[] args)
	{
		File objFile=new File("D:\\nt-pritz\\javase\\FileIO\\images");
		if(objFile.exists())
		{
			String [] arrFiles=objFile.list();
			for(String file:arrFiles)
			{
				System.out.println(file);
			
			}
		}
		else
			System.out.println("does not exist");

	}

	//creating a file
	public static void main3(String[] args)
	{
		try
		{
			File objFile=new File("D:\\nt-pritz\\javase\\FileIO\\images");
			if(!objFile.exists())
			{
				objFile.createNewFile();
				System.out.println("file created");
				
			}
			else
			{
				File[]arrFiles=objFile.listFiles();
				for(File file :arrFiles)
					file.delete();
				
				
			}
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main4(String[] args)

	{
		FileInputStream fis=null;
		try
		{
			File objFile=new File("D:\\nt-pritz\\javase\\FileIO\\images\\first.txt");
			fis =new FileInputStream(objFile);
			byte[] data=new byte[(int)objFile.length()];
			fis.read(data);
			System.out.println(new String(data));
		} 
		catch (FileNotFoundException e)
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
				if(fis!=null)
					fis.close();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args)
	{
		FileOutputStream fos=null;
		try
		{
			File objfFile =new File("D:\\nt-pritz\\javase\\FileIO\\images\\first.txt");
			if(!objfFile.exists())
				objfFile.createNewFile();
			
			fos=new FileOutputStream(objfFile);
			fos.write("hello world".getBytes());
			
			fos.write(String.valueOf(12).getBytes());
			System.out.println("file written");
		} catch (FileNotFoundException e)
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
				if(fos!=null)
				fos.close();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public static void main6(String[] args)
	{
		FileOutputStream fos=null;
		DataOutputStream dos=null;
		
		try
		{
			fos=new FileOutputStream("D:\\nt-pritz\\javase\\FileIO\\images\\first.txt");
			dos=new DataOutputStream(fos);
			
			dos.writeUTF("hello world");
			dos.writeInt(19);
			dos.writeFloat(88.23f);
		} catch (FileNotFoundException e)
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
				if(dos!=null)
					dos.close();
				if(fos!=null)
					fos.close();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}

	public static void main7(String[] args)
	{
		FileInputStream fis=null;
		DataInputStream dis=null;
		
		try
		{
			fis=new FileInputStream("D:\\nt-pritz\\javase\\FileIO\\images\\first.txt");
			dis=new DataInputStream(fis);
			
			System.out.println(dis.readUTF());
			System.out.println(dis.readInt());
			System.out.println(dis.readFloat());
		} catch (FileNotFoundException e)
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
				if(dis!=null)
					dis.close();
				
				if(fis!=null)
					fis.close();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main8(String[] args)
	{
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		
		try
		{
			fos=new FileOutputStream("D:\\nt-pritz\\javase\\FileIO\\images\\first.txt");
			oos=new ObjectOutputStream(fos);
			
			//Employee objEmployee=new Employee("neeraj", 1, 12.21f);
			Employee objEmployee=new Employee();
			objEmployee.id=1;
			objEmployee.name="hello";
			oos.writeObject(objEmployee);
			System.out.println("file written");
		} catch (FileNotFoundException e)
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
				if(oos!=null)
					oos.close();
				if(fos!=null)
					fos.close();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	
	public static void main9(String[] args)
	{
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		
		try
		{
			fis=new FileInputStream("D:\\nt-pritz\\javase\\FileIO\\images\\first.txt");
			ois=new ObjectInputStream(fis);
			System.out.println("ok1");
			Employee objEmployee =(Employee)ois.readObject();
			System.out.println("ok2");
		
			System.out.println(objEmployee.name);
			System.out.println(objEmployee.id);
			//System.out.println(objEmployee.name+objEmployee.id+objEmployee.salary);
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e)
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
				if(ois!=null)
					ois.close();
				if(fis!=null)
					fis.close();
				
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
}
