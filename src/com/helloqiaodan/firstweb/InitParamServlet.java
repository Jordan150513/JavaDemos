package com.helloqiaodan.firstweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamServlet
 */
@WebServlet("/InitParamServlet")
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitParamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset='UTF-8'><title>check Notice file</title></head>");
		out.println("<body>");
		out.println("<form action='"+request.getRequestURI()+"' method='post'>");
		out.println("name:<input type='text' name='username' style='width:200px; '>");
		out.println("password:<input type='password' name='password' style='width:200px; '>");
		out.println("<input type='submit' value='login'>");
		out.println("</form>");
		out.println("</body></html>");
		
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		//实现的过程中，在这里遇到一个问题，默认生成的代码在这里有一个doGet方法调用，不着调为啥要在这里调用这个，就导致了，没有取到用户名和密码参数，
		//注释掉这个方法，就取到了表单传过来的用户名和密码参数
//		System.out.println(request);
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		System.out.println(userName);
		System.out.println(passWord);
		Enumeration params = this.getInitParameterNames();
		
		while(params.hasMoreElements()){
			String userNameParam = (String)params.nextElement();
			String passWordParam = getInitParameter(userNameParam);
			if(userNameParam.equalsIgnoreCase(userName)&&passWordParam.equals(passWord)){
			request.getRequestDispatcher("/WEB-INF/notice.html").forward(request, response);
			request.getRequestDispatcher("identity.html").forward(request, response);
			return;
			}
		}
		this.doGet(request, response);
	}
	//访问路径：
	//http://localhost:8080/01-firstWeb/servlet/InitParamServlet
}
