package qiaodan.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qiaodan.db.DbClose;
import qiaodan.db.DbConn;
import qiaodan.entity.Register;

/**
 * 注册处理
 * Servlet implementation class HandleRegister
 */
@WebServlet("/HandleRegister")
public class HandleRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		Register userBean = new Register();
		request.setAttribute("userBead", userBean);
		
		String username = "";
		String userpass = "";
		String again_userpass = "";
		String phone = "";
		String address = "";
		String realname = "";
		
		username = request.getParameter("username").trim();
		userpass = request.getParameter("userpass").trim();
		again_userpass = request.getParameter("again_userpass").trim();
		phone = request.getParameter("phone").trim();
		address = request.getParameter("address").trim();
		realname = request.getParameter("realname").trim();
		
		if(username==null){
			username="";
		}
		
		if(userpass==null|userpass==""){
			userpass = "error";
		}
		
		String regex = "[\\d]{11}";
		if(!(again_userpass.equals(userpass))){
			//两次输入的密码不一样
			userBean.setBackNews("两次密码不一致，注册失败");
			request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
		}else if(phone!=null&&phone.length()>0&&!phone.matches(regex)){
			//手机号码错误
			userBean.setBackNews("请填写正确的手机号码！");
			request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
			return;
		}else{
			//
			String backNews = "";
			boolean userFlag = userpass.length()>5;
			if(userFlag){
				//密码大于5位
				Connection conn = null;
				PreparedStatement pstmt = null;
				conn = DbConn.getConn();
				String sql = "INSERT INTO vip(username,userpass,phone,address,realname) VALUES(?,?,?,?,?)";
				
				try{
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,username);
					pstmt.setString(2,userpass); 
					pstmt.setString(3,phone);
					pstmt.setString(4,address);
					pstmt.setString(5,realname);
					
					int rs = pstmt.executeUpdate();
					if(rs>0){
						backNews = "注册成功";
						userBean.setBackNews(backNews);
						request.getRequestDispatcher("/jsp/join/registerSuccess.jsp").forward(request, response);
					}
					
				}catch(SQLException e){
					
					System.out.println(e);
					backNews = "该用户名已被注册"+"<br>";
					userBean.setBackNews(backNews);
					request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
					
				}finally{
					
					DbClose.close(pstmt, conn);
				}
			}else{
				// 密码不合法
				userBean.setBackNews("密码不合法");
				request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
			}
		}
		
	}

}
