package qiaodan.goods;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class PutGoodsToCar
 */
@WebServlet("/PutGoodsToCar")
public class PutGoodsToCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PutGoodsToCar() {
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
		
		String goods = null;
		goods = request.getParameter("GoodsCar");
		if(goods==null){
			response.sendRedirect("/lyons.eaby/index.jsp");
		}else{
			//购物车里有东西
			 String[] details = null;
			 details = goods.split(",");//数组内存储的信息跟数据库的一致
			 
			 // 将物品信息放入模型之中
			 HttpSession session = request.getSession(true);
			 Login loginBean = (Login)session.getAttribute("loginBean");
			 LinkedList<String> car = null;
             car = loginBean.getCar();
             car.add(goods);
             loginBean.setCar(car);
             backNews(request,response,details[1]);// 参数三是商品名称
             
		}
	}

	/**
     * 
     * 返回用户消息
     * 添加购物车成功后，返回提示操作信息
     * @param request
     * @param response
     * @param goodsName
     * @throws IOException
     */
    private void backNews(HttpServletRequest request, HttpServletResponse response, String goodsName) throws IOException
    {
    	PrintWriter out = response.getWriter();
    	 out.print("<br><br><br>");
         out.print("<center><font size=5 color=red><B>"+goodsName+"</B></font>&nbsp;已成功添加购物车");
         out.print("<br><br><br>");
         out.print("<a href=/lyons.eaby/jsp/browse/showGoods.jsp>返回继续购物</a>");
         out.print("&nbsp;or&nbsp;");
         out.print("<a href=/lyons.eaby/jsp/shoppingCar/lookShoppingCar.jsp>查看购物车</a></center>");
         //这个href是需要更改的
    }
}
