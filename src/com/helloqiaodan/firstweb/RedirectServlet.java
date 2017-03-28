package com.helloqiaodan.firstweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * The Status Code
 * 1XX
 * 2XX 200 evert thing is ok 
 * 3XX redirect code
 * 4XX 404 not found 403 forbidden 401: has no right 405 the access method is wrong
 * 5XX:服务器错误 
 * Servlet implementation class RedirectServlet
 */
@WebServlet("/RedirectServlet")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String,Integer> map = new HashMap<String,Integer>();
   @Override
   public void init()throws ServletException{
	   map.put("/download/setup.exe", 0);
	   map.put("/download/application.zip", 0);
	   map.put("/download/01.mp3", 0);
   }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename = request.getParameter("filename");
		if(filename!=null){
			int hit = map.get(filename);
			map.put(filename, hit+1);
			response.sendRedirect(request.getContextPath()+filename);
		}else{
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			out.println("<HTML>");
			out.println("<HEAD><TITLE>File DownLoad</TITLE></HEAD>");
			out.println("<link rel='stylesheet' type='text/css'  href='../css/style.css'>");
			out.println("<BODY>");
			out.println("<fieldset align='center' srtle=width:90%><legend>File Downdload</legend>");
			out.println("<table width=100%>");
			out.println("<tr>");
			out.println("<td> file name </td>");
			out.println("<td> download time </td>");
			out.println("<td> download </td>");
			out.println("</tr>");
			for( Entry<String,Integer> entry:map.entrySet()){
				out.println("<tr>");
				out.println("<td>"+entry.getKey()+"</td>");
				out.println("<td>"+entry.getValue()+"</td>");
				out.println("<td><a href='"+request.getRequestURI()+"?filename="+entry.getKey()+"'target=' blank' onclick='location=location;'>downLoad</a></td>");
				// <a> click to the url :http://localhost:8080/JavaWebProjects/download/setup.exe
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</fieldset>");
			out.println("</BODY>");
			out.println("</HTML>");
				
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void destroy(){
		map=null;
	}
}
