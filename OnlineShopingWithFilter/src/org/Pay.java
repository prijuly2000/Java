package org;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Pay
 */
@WebServlet("/Pay")
public class Pay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 HttpSession session=request.getSession(false);
		 
		 if(session==null)
		 {
			 response.sendRedirect("login.html");
			 return;
		 }
		 
		 
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<form action='MakePayment' method='get'>");
		out.println("<table border='1'>");
		
		out.println("<tr>");
		out.println("<td>Total :</td>");
		out.println("<td><input type='text' disabled='disabled' value='"+session.getAttribute("total")+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Card No :</td>");
		out.println("<td><input type='text' name='cardNo'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>CVV :</td>");
		out.println("<td><input type='text' name='cvv'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Expiry Date:</td>");
		out.println("<td>");
		out.println("<select name='exMonth'>");
		for(int index=1;index<13;index++)
		{
			out.println("<option>"+index+"</option>");
		}
		out.println("</select>");
		out.println(" / ");
		out.println("<select name='exYear'>");
		for(int index=2012;index<2025;index++)
		{
			out.println("<option>"+index+"</option>");
		}
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Name :</td>");
		out.println("<td><input type='text' name='name'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td></td>");
		out.println("<td><input type='submit' value='Submit'></td>");
		out.println("</tr>");
			
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}

	
	

}
