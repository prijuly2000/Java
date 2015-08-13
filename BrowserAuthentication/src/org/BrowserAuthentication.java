package org;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Decoder;

public class BrowserAuthentication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		String objAuth=request.getHeader("authorization");
		if(objAuth==null)
		{
			invalidAuthentication(response);
			return;
			
		}
		String encAuth=objAuth.substring(6).trim();		
		BASE64Decoder decoder=new BASE64Decoder();
		byte[]data=decoder.decodeBuffer(encAuth);
		String decAuth=new String(data);
		String info[]=decAuth.split(":");
		if(info[0].equals("Neeraj")&&info[1].equals("Tiwari"))
			out.println("user authenticated");
		else
			invalidAuthentication(response);
	
	}
	
	public void invalidAuthentication(HttpServletResponse response)throws IOException,SecurityException
	{
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.addHeader("www-authenticate", "BASIC realm =Neeraj's online shoping ");
		
	}

}
