package com.helloqiaodan.firstweb;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardServlet
 */
// it can be used except the LifeCycleServlet so i replace the lifeCycleServlet with the Test
@WebServlet("/ForwardServlet")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String destination = request.getParameter("destination");
		if("file".equals(destination)){
			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/web.xml");
			d.forward(request, response);
		}else if("jsp".equals(destination)){
			request.setAttribute("date", new Date());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/forward.jsp");
				dispatcher.forward(request, response);
		}else if("servlet".equals(destination)){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet/Test");
			dispatcher.forward(request, response);
		}else{
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(" in lack of the parameter.use"+request.getRequestURL()+"?destination=jsp or file or servlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
