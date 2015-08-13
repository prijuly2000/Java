package sj.tag;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


public class QueryTag extends TagSupport
{
	PreparedStatement psSelect=null;
	ResultSet result=null;
	String sql;
	public String getSql()
	{
		return sql;
	}
	public void setSql(String sql)
	{
		this.sql = sql;
	}

	@Override
	public int doStartTag()throws JspException
	{
		JspWriter out=pageContext.getOut();
		
		ConnectTag parentTag=(ConnectTag)findAncestorWithClass(this,ConnectTag.class);
		if(parentTag==null)
			throw new JspException("Improper nesting");
		
		try
		{
			Connection connection=parentTag.getConnection();
			psSelect=connection.prepareStatement(sql);
			psSelect.executeUpdate();
			
			
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return EVAL_BODY_INCLUDE;
	}
}
