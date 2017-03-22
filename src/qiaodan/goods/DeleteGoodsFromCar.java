package qiaodan.goods;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qiaodan.entity.Login;

/**
 * 
 * 
 * 处理删除 购物车 商品
 *
 * Servlet implementation class DeleteGoodsFromCar
 */
@WebServlet("/DeleteGoodsFromCar")
public class DeleteGoodsFromCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteGoodsFromCar() {
        super();
        
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int deleteID = -1;
		deleteID = Integer.parseInt(request.getParameter("ID"));
		System.out.println("删除数组下标为:"+deleteID);
		
		HttpSession session = request.getSession(true);
		Login loginBean = (Login)session.getAttribute("loginBean");
		LinkedList<String> car = loginBean.getCar();
		car.remove(deleteID);
		loginBean.setCar(car);
		
		request.getRequestDispatcher("/jsp/shoppingCar/lookShoppingCar.jsp").forward(request, response);
	}

}
