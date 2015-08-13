package org;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class ConnectTag extends TagSupport
{

	Connection connection=null;
	ResultSet result=null;
	PreparedStatement psSelect=null;
	
	
	@Override
	public int doEndTag() throws JspException
	{
		try
		{
			if(result!=null)
				result.close();
			if(connection!=null)
				connection.close();
			if(psSelect!=null)
				psSelect.close();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException
	{
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@172.25.12.1:1521:orcl","user101","user101");
			psSelect=connection.prepareStatement("select * from category");
			
			JspWriter out=pageContext.getOut();
			result=psSelect.executeQuery();
			while(result.next())
			{
				out.println("<tr>");
				out.println("<td>"+result.getString(1)+"</td>");
				out.println("<td>"+result.getString(2)+"</td>");
				out.println("<td>"+result.getString(3)+"</td>");
				out.println("</tr>");
			}
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
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return EVAL_BODY_INCLUDE;
			
	}
	

}
