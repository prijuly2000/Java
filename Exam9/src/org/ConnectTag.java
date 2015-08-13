package org;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ConnectTag extends TagSupport
{
	Connection connection;
	ResultSet result;
	PreparedStatement psInsert;

	@Override
	public int doEndTag() throws JspException
	{
		try
		{
			if(connection!=null)
				connection.close();
			if(result!=null)
				result.close();
			if(psInsert!=null)
				psInsert.close();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException
	{
		Student objStudent=(Student)pageContext.getAttribute("objStudent");
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@172.25.12.1:1521:orcl","user101","user101");
			psInsert=connection.prepareStatement("insert into Student values(?,?,?,?,?,?)");
			
			psInsert.setString(1, objStudent.getId());
			psInsert.setString(2, objStudent.getName());
			psInsert.setString(3, objStudent.getCity());
			psInsert.setString(4, objStudent.getPin());
			psInsert.setString(5, objStudent.getEmail());
			psInsert.setString(6, objStudent.getMobile());
			psInsert.executeUpdate();
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return EVAL_BODY_INCLUDE;
	}
	
}
