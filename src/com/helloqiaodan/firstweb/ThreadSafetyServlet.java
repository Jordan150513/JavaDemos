package com.helloqiaodan.firstweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThreadSafetyServlet
 */
@WebServlet("/ThreadSafetyServlet")
public class ThreadSafetyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String name; // doGet() doPost() use this
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThreadSafetyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		name = request.getParameter("name");
		try{
			Thread.sleep(10000);
		}catch(InterruptedException e){}
		response.getWriter().println("Hello"+ name +". You use get to access this ervlet.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		name = request.getParameter("name");
		response.getWriter().println("Hello "+ name +". You use get to access this ervlet.");
	}

	//the later coming servlet instance may change mutex static variable "name",then the earlier servlet instance mar read the dirty data.
}
