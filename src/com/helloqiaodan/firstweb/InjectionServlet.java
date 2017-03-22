package com.helloqiaodan.firstweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//访问路径：
	//http://localhost:8080/01-firstWeb/servlet/InjectionServlet
/**
 * Servlet implementation class InjectionServlet
 */
@WebServlet("/InjectionServlet")
public class InjectionServlet extends HttpServlet {
	
	//资源注射
	private @Resource(name="hello") String hello;//注入的字符串，一行的写法
	
	private @Resource(name="i") int i;//注入的整数，一行的写法
	
	@Resource(name="persons")//注入的是一个字符串，两行的注入写法
	private String persons;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InjectionServlet() {
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
		out.println("");
		out.println("<html>");
		out.println("<head><title>Injection Resource</title></head>");
		out.println("<style>body {font-size:12px;}</style>");
		out.println("<body>");
		out.println("Injection String:"+hello);
		out.println("<br />");
		out.println("Injection int:"+i);
		out.println("<br />");
		out.println("Injection char string:"+persons);
		out.println("<br />");
		for(String person :persons.split(",")){
			out.println("person:"+person);
			out.println("<br />");
		}
		out.println("");
		out.println("</body>");
		out.println("</html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
