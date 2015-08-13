package org;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import oracle.security.o3logon.O3LoginClientHelper;

public class QueryTag extends TagSupport
{
	PreparedStatement psSelect=null;
	ResultSet result=null;
	String sql=null;
	
	
	@Override
	public int doEndTag() throws JspException
	{
		try
		{
			if(psSelect!=null)
				psSelect.close();
			if(result!=null)
				result.close();
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
		try
		{
			JspWriter out=pageContext.getOut();
			ConnectTag parentTag=(ConnectTag)findAncestorWithClass(this, ConnectTag.class);
			if(parentTag==null)
				throw new JspException("Improper Nesting");
			Connection connection=parentTag.getConnection();
			psSelect=connection.prepareStatement(sql);
			result=psSelect.executeQuery();
			
			if(result.next())
			{
				Admission objAdmission=new Admission(result.setString(2), result.setString(3), result.setString(4));
				
				pageContext.setAttribute("result", objAdmission);
				
			}
		
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doAfterBody() throws JspException
	{
		try
		{
			if(result.next())
			{
				Admission objAdmission =new Admission(result.String("email"),result.setString("classJoin"),result.setString("Mobile"));
				
				pageContext.setAttribute("result", objAdmission);
				return EVAL_BODY_AGAIN;
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
		
	}
	public String getSql()
	{
		return sql;
	}
	public void setSql(String sql)
	{
		this.sql = sql;
	}
	
	
	

}
	
	


