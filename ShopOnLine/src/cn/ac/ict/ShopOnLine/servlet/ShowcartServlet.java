package cn.ac.ict.ShopOnLine.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ac.ict.ShopOnLine.model.ShoppingCart;
import cn.ac.ict.ShopOnLine.model.ShoppingItem;
import cn.ac.ict.ShopOnLine.service.ShowcartService;

/**
 * Servlet implementation class ShowcartServlet
 */
@WebServlet("/ShowcartServlet")
public class ShowcartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowcartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ShowcartService service = new ShowcartService();
		ShoppingCart shopcart;
		HttpSession session = request.getSession();
		if((ShoppingCart) session.getAttribute("shopcart")!=null) {		
			shopcart = (ShoppingCart) session.getAttribute("shopcart");
		}else {
			shopcart = new ShoppingCart();
		}
		float totalCut =0.0f;
		if(session.getAttribute("totalCut")!=null) {
			totalCut = (float) session.getAttribute("totalCut");
		}
		totalCut= shopcart.getTotalCut();
		float totalReal = 0.0f;
		if(session.getAttribute("totalReal")!=null) {
			totalReal = (float) session.getAttribute("totalReal");
		}
		totalReal = shopcart.getTotalReal();
		String proJson = service.getProductFromCart((Collection<ShoppingItem>)shopcart.getItems(),totalReal,totalCut);
		//将数据返回给客户端
		response.getWriter().print(proJson);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
