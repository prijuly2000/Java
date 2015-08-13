package org;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ListCart
 */
@WebServlet("/ListCart")
public class ListCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
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
			out.println("Welcome <b>"+session.getAttribute("userName")+"</b>");
			Cart cart=(Cart)session.getAttribute("cart");
			int total=0;
			if(cart==null )
				out.println("your cart is empty");
			else
			{
				Iterator<Product>itr=cart.list();
				out.println("<table border='1'>");
				out.println("<tr>");
				out.println("<th>catId</th>");
				out.println("<th>prodId</th>");
				out.println("<th>qty</th>");
				out.println("<th>price</th>");
				out.println("</tr>");
				
				
				
				
				while(itr.hasNext())
				{
					Product objProduct=itr.next();
					out.println("<tr>");
					out.println("<td>"+objProduct.getCatId()+"</td>");
					out.println("<td>"+objProduct.getProdId()+"</td>");
					out.println("<td>"+objProduct.getQty()+"</td>");
					out.println("<td>"+objProduct.getPrice()+"</td>");
					out.println("</tr>");
					total+=(int)objProduct.getPrice();
				}
				out.println("</table>");
				out.println("total:<b>"+total+"</b><br/>");
				
			}
			session.setAttribute("total",total);
			out.println("<a href='Category'>contine shopping</a><br/>");
			out.println("<a href='Pay'>Pay</a>");
			out.println("<a href='Logout'>Logout</a>");

			out.println("</body>");
			out.println("</html>");
		}
		catch (CartException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
