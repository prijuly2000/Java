package org;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			HttpSession session=request.getSession(false);
			if(session==null)
			{
				response.sendRedirect("index.html");
				return;
			}
			
			String tmp=request.getParameter("catId");
			int catId=Integer.parseInt(tmp);
			
			tmp=request.getParameter("prodId");
			int prodId=Integer.parseInt(tmp);
			
			tmp=request.getParameter("qty");
			int qty=Integer.parseInt(tmp);
			
			tmp=request.getParameter("prodPrice");
			float prodPrice=Float.parseFloat(tmp);
			
			Product objProduct=new Product(catId,prodId,qty,prodPrice);
			
			Cart cart=(Cart)session.getAttribute("cart");
			
			if(cart==null)
			{
				cart=CartFactory.getCart(getServletContext());
				session.setAttribute("cart", cart);
			}
			cart.add(objProduct);
			response.sendRedirect("ListCart");
		}
		catch (NumberFormatException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (CartException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
