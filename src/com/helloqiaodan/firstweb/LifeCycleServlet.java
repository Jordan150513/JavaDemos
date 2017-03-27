package com.helloqiaodan.firstweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * the personal tax demo to show the life cycle of the servlet.
 * has some problem
 * Servlet implementation class LifeCycleServlet
 */
@WebServlet("/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static double startPoint = 0.00; //personal tax start point read from the web.xml file the init-param node
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		this.log("execute the init() method...");
		ServletConfig conf = this.getServletConfig();
		startPoint = Double.parseDouble(conf.getInitParameter("startPoint")) ;	
		//  init parameter 'startPoint'
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		
		this.log("execute destroy() method ...");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.log("execute service() method ...");
		super.service(request, response);
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		this.log("execute doGet() method ...");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		// use this method also can not resovel this problem
//		ServletContext servletContext = this.getServletConfig().getServletContext();
//		startPoint = Double.parseDouble(servletContext.getInitParameter("startPoint")) ;
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCUMENT HTML>");
		out.println("<HTML><HEAD><TITLE>Individual income tax Caculation </TITLE></HEAD></HTML>");
		out.println("<link rel='stylesheet' type='text/css' href='../css/style.css'> ");
		out.println("<body>");
		out.println("<div class = 'leftDiv'>Your Income is:</div><div aligment = 'left' class='rightDiv'><input type='text' name='income'>Unit:Yuan</div>");
		out.println("<div class='leftDiv'></div><div align='left' class='rightDiv'><input type='submit' value='Caculate The Income tax' class='button'></div>");
		out.println("</body>");
		out.println("");
		out.println("");
		out.println("");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.log("execute doPost() method ...");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCUMENT HTML>");
		out.println("<HTML><HEAD><TITLE>Individual income tax Caculation </TITLE></HEAD></HTML>");
		out.println("<link rel='stylesheet' type='text/css' href='../css/style.css'> ");
		out.println("<body>");
		out.println("<div align='center'><br><fieldset style=width:90%><legend>The cacaulation of the income tax</legend>");
		try{
			Double income = new Double(request.getParameter("income"));
			Double charge = income-startPoint;
			Double tax = 0.0;
			if(charge<0){tax=0.0;}
			if(charge>0&&charge<=500) {tax=charge*0.05;}
			if(charge>500&&charge<=2000){tax=charge*0.1-25;}
			if(charge>2000&&charge<=5000){tax = charge*0.15-125;}
			if(charge>5000&&charge<=20000){tax= charge*0.2-375;}
			if(charge>20000&&charge<=40000){tax=charge*0.25-1375;}
			if(charge>40000&&charge<=60000){tax=charge*0.30-3375;}
			if(charge>60000&&charge<=80000){tax=charge*0.35-6375;}
			if(charge>80000&&charge<=100000){tax=charge*0.4-10375;}
			if(charge>100000){tax=charge*0.45-15375;}
			out.println("Your income is"+income+"Yuan.<br>");
			out.println("Your tax is"+tax+"Yuan.<br>");
			
		}catch(Exception e){
			out.println("please input the munber value.<input type='button' onclick='history.go(-1);' value='back' class='button'>");
		}
		out.println("</fieldset></div><br>");
		out.println("</body>");
	}

}
