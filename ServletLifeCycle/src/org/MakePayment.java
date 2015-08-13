package org;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MakePayment
 */
@WebServlet("/MakePayment")
public class MakePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			PrintWriter out=response.getWriter();
			HttpSession session=request.getSession(false);
			if(session==null)
			{
				response.sendRedirect("index.html");
				return;
			}
			
			int total=(int)session.getAttribute("total");
			
			request.getParameter("cardNo");
			int cardNo=Integer.parseInt(request.getParameter("cardNo"));
			
			int cvv=Integer.parseInt(request.getParameter("cvv"));
			
			int exMonth=Integer.parseInt(request.getParameter("exMonth"));
			
			int exYear=Integer.parseInt(request.getParameter("exYear"));
			
			Date expiry=new Date(exYear,exMonth,0);
			String name=request.getParameter("name");
			
			CardValidator cvi=(CardValidator)Naming.lookup("Cards");
			boolean isValid=cvi.validateCard(cardNo, name,expiry,cvv,total);
			
			if(isValid)
			{
				out.println("Successfull payment");
			}
			else
			{
				out.println("Failed payment");
			}
		}
		catch (NumberFormatException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NotBoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}

	
}
