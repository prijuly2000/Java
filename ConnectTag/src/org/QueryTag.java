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
				Category objCategory=new Category(result.getString(2), result.getString(3), result.getString(4));
				
				pageContext.setAttribute("result", objCategory);
				
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
				Category objCategory =new Category(result.getString("catName"),result.getString("catDesc"),result.getString("catImage"));
				
				pageContext.setAttribute("result", objCategory);
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
	
	


