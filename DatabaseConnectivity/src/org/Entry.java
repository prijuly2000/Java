package org;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Entry
{
	//For oracle connectivity i.e. type 4
	public static void main1(String[] args)
	{
		Connection connection=null;
		Statement stStatement=null;
		ResultSet result=null;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:Oracle:thin:@172.25.12.1:1521:orcl","user101","user101");
			
			stStatement=connection.createStatement();
			result=stStatement.executeQuery("select * from emp");
			
			while(result.next())
			{
				System.out.println(result.getString("empno")+" "+result.getString("ename")+" "+result.getString("job"));;
				
			}
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//MySql connectivity
	public static void main2(String[] args)
	{
		Connection connection=null;
		Statement stStatement=null;
		ResultSet result=null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost/nt-pritz","root","admin");
			
			stStatement=connection.createStatement();
			result=stStatement.executeQuery("select * from emp");
			
			while(result.next())
			{
				System.out.println(result.getString("eid"));
				System.out.println(result.getString("ename"));
				System.out.println(result.getString("salary"));
				
			}
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	//Using Command line arguments
	public static void main3(String[] args)
	{
		Connection connection=null;
		PreparedStatement stStatement=null;
		ResultSet result=null;
		
		try
		{
			Class.forName(args[0]);
			System.out.println("connecting...");
			connection=DriverManager.getConnection(args[1],args[2],args[3]);
			System.out.println("connected to server...");
			stStatement=connection.prepareStatement("insert into employee values(?,?,?)");
			
			Scanner scanner=new Scanner(System.in);
			System.out.println("enter the Eid");
			int id=scanner.nextInt();
			System.out.println("enter the Ename");
			String name=scanner.next();
			System.out.println("enter the Salary");
			int salary=scanner.nextInt();
			
			stStatement.setInt(1, id);
			stStatement.setString(2, name);
			stStatement.setInt(3, salary);
			
			stStatement.executeUpdate();
			
			System.out.println("record saved");
			
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
						
	}
	
	//Using file configuration
	public static void main4(String[] args)
	{
		Connection connection=null;
		PreparedStatement stStatement=null;
		ResultSet result=null;
		
		try
		{
			Properties properties=new Properties();
			properties.load(new FileInputStream("db.properties"));
			String url=properties.getProperty("db.url");
			String user=properties.getProperty("db.user");
			String pwd=properties.getProperty("db.pwd");
			String driver=properties.getProperty("db.driver");
			
			Class.forName(driver);
			
			System.out.println("Connecting..");
			connection=DriverManager.getConnection(url,user,pwd);
			System.out.println("connected to server...");
			stStatement=connection.prepareStatement("insert into employee values(?,?,?)");
			
			Scanner scanner=new Scanner(System.in);
						
			System.out.println("Enter the id");
			int id=scanner.nextInt();
			System.out.println("Enter the ename");
			String name=scanner.next();
			System.out.println("Enter the salary");
			int salary=scanner.nextInt();
			
			stStatement.setInt(1, id);
			stStatement.setString(2, name);
			stStatement.setInt(3, salary);
			
			
			stStatement.executeUpdate();
			System.out.println("Row inserted");
			
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
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}

	//Database MetaData
	public static void main(String[] args)
	{
		Connection connection=null;
		Statement stStatement=null;
		ResultSet result=null;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("connecting");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@172.25.12.1:1521:orcl","user101","user101");
			System.out.println("connected successfully");
			stStatement=connection.createStatement();
			result=stStatement.executeQuery("select * from employee");
			DatabaseMetaData dmd=connection.getMetaData();
			System.out.println("Started metadata");
			result=dmd.getTables(null,null,null,new String[]{"TABLE"});
			System.out.println("got it");
			ResultSet resultColumns=null;
			System.out.println(result.next());
			while(result.next())
			{
				System.out.println(result.getString(3));
				resultColumns=dmd.getColumns(null, null, result.getString(3), null);
				System.out.println("got it");
				while(resultColumns.next())
				{
					System.out.println(resultColumns.getString(4));
					System.out.println(resultColumns.getString(5));
					System.out.println(resultColumns.getString(6));
					
				}
			}
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
