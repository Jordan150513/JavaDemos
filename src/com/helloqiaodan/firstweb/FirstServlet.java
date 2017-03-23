package com.helloqiaodan.firstweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.log("执行doGet方法");
		
		
		//调用公共处理方法
		this.execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		this.log("执行doPost方法");
		
		//调用公共处理方法
		this.execute(request, response);
	}
	
	@Override
	public long getLastModified(HttpServletRequest request){
		this.log("执行getLastModified方法");
		//验证了只有get方法会调用该方法，post方法不会调用该方法
		return -1;
	}
	
	private void execute(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String requestURI = request.getRequestURI();
		String requestMethod = request.getMethod();
		String param = request.getParameter("param");
	
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<Body>");
		out.println("<head><title>FirstServlet</title></head>");
		out.println("用"+requestMethod+"的方式访问页面，取到的parameter参数为："+param+"<br/>");
		out.println("<form action='"+requestURI+"' method='get'> <input type='text' name='param' value='param string'> <input type='submit' value='以get方式查询页面"+requestURI+"'> </form>");
		
		out.println("<form action='"+requestURI+"' method='post'> <input type='text' name='param' value='param string'> <input type='submit' value='以post方式查询页面"+requestURI+"'> </form>");
		
		out.println("<script>document.write('本页面最后更新时间：' + document.lastModified);</script>");
		out.println("</Body>");
		out.println("</HTML>");
		
	}

}
//访问路径：http://localhost:8080/01-firstWeb/servlet/FirstServlet







