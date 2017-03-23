package com.helloqiaodan.firstweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//访问html路径：
//http://localhost:8080/01-firstWeb/postPersonInformation.html
//访问路径：
	//http://localhost:8080/01-firstWeb/servlet/PostServlet
//file:///D:/workspace/01-firstWeb/WebContent/01-firstWeb/servlet/PostServlet
//http://localhost:8080/servlet/PostServlet
/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
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
		response.getWriter().println("please use the post method");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		
		int age = 0;
		try{
			age=Integer.parseInt(request.getParameter("age"));
		}catch(Exception e){}
		Date birthday = null;
		try{
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			birthday = format.parse(request.getParameter("birthday"));
		}catch(Exception e){}
		
		String[] interesting = request.getParameterValues("interesting");
		String area = request.getParameter("area");
		String description = request.getParameter("description");
		String btn = request.getParameter("btn");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><meta charset='UTF-8'>");
		out.println("<title>thank you for submitting your Information</title>");
		out.println("<head>");
		out.println("<body>");
		out.println("name:"+name);
		out.println("password:"+password);
		out.println("sex:"+sex);
		out.println("age:"+age);
		out.println("intresting:");
		for(String str:interesting){
			out.println(str+",");
			}
		out.println("area:"+area);
		out.println("description:"+description);
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("");
		out.println("</body>");
		out.println("</html>");
		
	}

}
