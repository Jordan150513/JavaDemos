package com.helloqiaodan.firstweb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//练习1
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		 out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<meta http-equiv=\"content-typpe\" content=\"text/html; charset=UTF-8\">");
		out.print("<HEAD><TITLE> A Servlet </TITLE>");
		out.println("<meta http-equiv=\"content-typpe\" content=\"text/html; charset=UTF-8\">");
		out.println("</HEAD>");
		out.println("<BODY>");
		
		String requestURI = request.getRequestURI();//获取到URI路径
		out.println("<form action='"+requestURI+"' method='post'>");
		out.println("Please input your name:<input type='text' name='name' />");
		out.println("<input type='submit' />");
		out.println("</form>");
		out.println(" ");
		
		String name = request.getParameter("name");
		if(name != null &&name.trim().length()>0){
			out.println("Hello,<b>"+name+"</b>.Welcome to java Web.");
		}
		//练习从请求中获取参数，并且反馈展示出来
		//遇到的问题，html文件没有正确使用UTF-8编码，所以没有识别中文
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		//访问的路径
		//http://localhost:8080/01-firstWeb/servlet/HelloServlet
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
