package cn.ac.ict.ShopOnLine.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ac.ict.ShopOnLine.model.Product;
import cn.ac.ict.ShopOnLine.service.ProductService;

/**
 * Servlet implementation class Putintocart
 */
@WebServlet("/Putintocart")
public class Putintocart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Putintocart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String addpid = request.getParameter("add");
		Product pro= null;
		HttpSession session = null;
		if(null!=addpid) {
			//创建service对象
			ProductService ps = new ProductService();
			//根据id获取商品信息
			if(ps.getProductById(addpid)!=null) {
				pro = ps.getProductById(addpid);
			}else {
				pro = new Product();
			}
			//保存在session对象中
			session = request.getSession();
			session.setAttribute("pro", pro);
			response.sendRedirect("add.jsp?add="+addpid);
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
