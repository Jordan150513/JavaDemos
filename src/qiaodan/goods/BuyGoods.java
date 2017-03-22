package qiaodan.goods;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.rowset.CachedRowSetImpl;

import qiaodan.db.DbClose;
import qiaodan.db.DbConn;
import qiaodan.entity.Goods;
import qiaodan.entity.Login;

/**
 * Servlet implementation class BuyGoods
 */
@WebServlet("/BuyGoods")
public class BuyGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyGoods() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy()
    {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
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
		
		HttpSession session = request.getSession(true);
		Login loginBean = (Login)session.getAttribute("loginBean");
		String userName = "myNull";
		userName = loginBean.getUsername();
		LinkedList<String> car = null;
		car = loginBean.getCar();
		
		//购物车是否是空的
		if(car.size()!=0){
			boolean flag = false;
			Connection  conn = null;
			PreparedStatement pstmtCommodity = null;
            PreparedStatement pstmtOrder = null;
          //将商品行集数据遍历到数组中
            for (int i = 0,m=car.size(); i < m; i++)
            {
                    String[] goods = null;
                    conn = DbConn.getConn();
                    goods = car.get(i).split(",");
                    
                    String sqlCommodity = null;
                    String sqlOrder = null;
                    sqlCommodity = "update Commodity set commodity_balance=? where commodity_number=?";
                    sqlOrder = "insert into orderForm(username,commodity_name,commodity_price,sum) values(?,?,?,?)";
    
                        try
                        {
                            pstmtCommodity = conn.prepareStatement(sqlCommodity);
                            pstmtOrder = conn.prepareStatement(sqlOrder);
                            
                            pstmtOrder.setString(1,userName);
                            pstmtOrder.setInt(4,1);//默认数量为1，后期再增添选择购买数量
                            
                           /* 2-安踏运动鞋-福州-120-800-002.jpg-1-
                            10-ipad5-北京-5900-500-010.jpg-4-
                            10-ipad5-北京-5900-500-010.jpg-4-*/
                            
                            //将商品各行具体数据遍历到数组中,并对应  修改sqlCommodity、写入sqlOrder 的sql语句占位符
                            for (int j = 0,n=goods.length; j < n; j++)
                            {
                                switch (j)
                                {
                                    case 0:
                                            String commodity_number = null;
                                            commodity_number = goods[0];
                                            pstmtCommodity.setString(2,commodity_number);
                                        break;
                                    case 1:
                                            String commodity_name= null;
                                            commodity_name = goods[1];
                                            pstmtOrder.setString(2,commodity_name); 
                                        break;
                                    case 2:
                                        break;
                                    case 3:
                                            Double commodity_price = 0.00;
                                            commodity_price = Double.parseDouble(goods[3]);
                                            pstmtOrder.setDouble(3,commodity_price); 
                                        break;
                                    case 4:
                                            int commodity_balance = -1;
                                            System.out.println(Integer.parseInt(goods[4]));
                                            commodity_balance = Integer.parseInt(goods[4])-1;//目前是默认每次修改一个
                                            System.out.println(commodity_balance);
                                            if (commodity_balance >= 0)
                                            {
                                                pstmtCommodity.setInt(1,commodity_balance);
                                            }else 
                                                {
                                                    String failNumber = "数据库中商品不足";
                                                    messShopping(request,response,failNumber);
                                                }
                                        break;
                                    default:
                                        System.out.println("defalut01");
                                        break;
                                }
                                System.out.println("defalut02");
                            }
                                
                            
                                int rsCommodity = pstmtCommodity.executeUpdate();
                                int rsOrder = pstmtOrder.executeUpdate();
                                if (!(rsCommodity > 0 && rsOrder > 0))//插入失败
                                {
                                    String failError = "与数据库对接时出现异常";
                                    messShopping(request,response,failError);
                                }else 
                                    {
                                    System.out.println(i+"此次循环商品购买成功");
                                        flag = true;//此次循环商品购买成功
                                    }
                                
                        } catch (SQLException e)
                        {
        //                   此地需要回滚数据！！！未实现
                           /*String backNews = "购物失败"+"<br>"+e;
                           loginBean.setBackNews(backNews);//为了省事，直接用lyons.entity/Login.java 类
*/                           System.out.println("莫名异常："+e);
                           
                            PrintWriter out = response.getWriter();
                            out.print(e+"<br>");
                            out.print("返回"+"");
                            out.print("<a href=/lyons.eaby/jsp/shoppingCar/lookShoppingCar.jsp>购物车</a>");
                            return;
                        }finally
                        {
                            DbClose.close(pstmtOrder,pstmtCommodity, conn);
                        }
                        
                continue;
             }
                    
                if (flag==true)
                {
                    //付款成功，清除数据模型中的数据
                    car.clear();
                    /*//从行集中更新数据库信息
                    request.getRequestDispatcher("/lyons.dao/GoodsDao?key=3").forward(request, response);*/
                    
                    updateInfo(request,response);
                    
                    String successBackNews = "您已将购物车中的商品买回家了";
                    messShopping(request,response,successBackNews);
                }
            }
        return;
     
    }
	
	/**
     * 
     * 从数据库中更新行集对象
     * <功能详细描述>
     * @param request
     * @param response
     * @throws IOException 
     */
    private void updateInfo(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        CachedRowSetImpl rowSet = null;//行集对象
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Goods goods = null;
        
        HttpSession session = request.getSession(true);
        goods = (Goods)session.getAttribute("goods");
//      ArrayList<Goods> goodsList = new ArrayList<Goods>();
        if (goods==null)
        {
            goods = new Goods();
            session.setAttribute("goods", goods);
        }
        
        conn = DbConn.getConn();
        
        String sqlListClear= "select * from commodity";
        try
        {
            pstmt = conn.prepareStatement(sqlListClear);
            rs = pstmt.executeQuery();
            System.out.println("3执行数据库操作");
            while (rs.next())
            {
                rowSet = new CachedRowSetImpl();
                rowSet.populate(rs);
                goods.setRowSet(rowSet);
                System.out.println("3已经从数据库中获取到值，并塞进行集");
            }
        } catch (SQLException e)
        {
            System.out.println("GoodsDao.java k=3 再次查询时出现异常："+e);
            PrintWriter out = response.getWriter();
            out.print(e+"<br>");
            out.print("返回"+"");
            out.print("<a href=/lyons.eaby/jsp/shoppingCar/lookShoppingCar.jsp>购物车</a>");
        }finally
                {
                    DbClose.allClose(pstmt, rs, conn);
                }
        
    }

    /**
     * 
     * 商品购买处理信息
     * <功能详细描述>
     * @param request
     * @param response
     * @param failNumber
     */
    public void messShopping(HttpServletRequest request, HttpServletResponse response, String mess)
    {
        try
        {
            PrintWriter out = response.getWriter();
            out.print("<br><br><br>");
            out.print("<center><font size=5 color=red><B>"+mess+"</B></font>&nbsp;");
            out.print("<br><br><br>");
            out.print("<a href=/lyons.eaby/jsp/browse/showGoods.jsp>返回继续购物</a>");
            out.print("&nbsp;or&nbsp;");
            out.print("<a href=/lyons.eaby/lyons.dao/GoodsDao?key=3>查看订单</a></center>");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        
    }

    public void init()
        throws ServletException
    {
    }
    
}
