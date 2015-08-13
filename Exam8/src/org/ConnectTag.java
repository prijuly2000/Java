package org;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import sun.rmi.transport.proxy.HttpReceiveSocket;



public class ConnectTag extends TagSupport 
{
	
	private static final long serialVersionUID = 1L;
	
	Connection connection=null;
	ResultSet result=null;
	PreparedStatement psInsert=null;
	public  int limit=9;

	@Override
	public int doEndTag() throws JspException
	{
		try
		{
			if(limit<10)
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@172.25.12.1:1521:orcl","user101","user101");
			psInsert=connection.prepareStatement("insert into Admission values(?,?,?,?)");
			
			Admission objUser=(Admission)pageContext.getAttribute("objUser");
			psInsert.setString(1, objUser.name);
			psInsert.setString(2, objUser.email);
			psInsert.setString(3, objUser.className);
			psInsert.setString(4, objUser.mobile);
			
			psInsert.executeUpdate();
			limit++;
			System.out.println("Record Inserted....");
			HttpServletResponse response=(HttpServletResponse) pageContext.getResponse();
			response.sendRedirect("ok.html");
			}
			else
			{
				HttpServletResponse response=(HttpServletResponse) pageContext.getResponse();
				//JspWriter out=response.getWriter();
				try {
					response.sendRedirect("cannot.html");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
		
	}

	@Override
	public int doStartTag() throws JspException
	{
		try
		{
			if(psInsert!=null)
				psInsert.close();
			if(result!=null)
				result.close();
			if(connection!=null)
				connection.close();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return EVAL_PAGE;
	}
	
}
