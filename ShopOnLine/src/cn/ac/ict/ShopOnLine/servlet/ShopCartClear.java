package cn.ac.ict.ShopOnLine.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ac.ict.ShopOnLine.model.ShoppingCart;

/**
 * Servlet implementation class ShopCartClear
 */
@WebServlet("/ShopCartClear")
public class ShopCartClear extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopCartClear() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("confirm")!=null) {
			String confirm = request.getParameter("confirm");
			if(confirm.equalsIgnoreCase("clear")||confirm.equalsIgnoreCase("pay")) {
				HttpSession session = request.getSession();
				if(session.getAttribute("shopcart")!=null) {
					ShoppingCart shopcart;
					shopcart = (ShoppingCart) session.getAttribute("shopcart");
					shopcart.clear();
					session.removeAttribute("shopcart");
				}
				if(confirm.equalsIgnoreCase("clear")) {
					response.sendRedirect("showcart.jsp?clear=true");
				}
				if(confirm.equalsIgnoreCase("pay")) {
					response.sendRedirect("pay.jsp");
				}
					
			}
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
