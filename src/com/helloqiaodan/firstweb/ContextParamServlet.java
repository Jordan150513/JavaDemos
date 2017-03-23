package com.helloqiaodan.firstweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//访问路径：
	//http://localhost:8080/01-firstWeb/servlet/ContextParamServlet
/**
 * Servlet implementation class ContextParamServlet
 */
@WebServlet("/ContextParamServlet")
public class ContextParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextParamServlet() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("");
		out.println("<html>");
		out.println("<head><title>read the context params</title></head>");
		out.println("<body");
		out.println("<div align=center><br />");
		out.println("<fieldset style='width=90%'><legend>all the context params</legend><br />");
		
		ServletContext servletContext = getServletConfig().getServletContext();
		String uploadFolder = servletContext.getInitParameter("upload folder");
		String allowedFileTypes = servletContext.getInitParameter("allowed file type");
		
		out.println(uploadFolder);
		out.println("<br />");
		out.println(servletContext.getRealPath(uploadFolder));
		out.println("<br />");
		out.println(allowedFileTypes);
		out.println("<br />");
		
		//输出到控制台
		System.out.println(uploadFolder);
		System.out.println(servletContext.getRealPath(uploadFolder));
		System.out.println(allowedFileTypes);
		//输出结果：
		//attachment
		//D:\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\01-firstWeb\attachment
		//.gif,.jpg,.bmp
		//可以正确的获取到配置的context-params
		out.println("");
		out.println("</fieldset>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		//为啥doPost方法里要默认调用一个doGet方法呢？
		
	}

}
