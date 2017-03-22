package qiaodan.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HandleExit
 */
@WebServlet("/HandleExit")
public class HandleExit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleExit() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void destroy()
	{
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);//true一定要写。否则，获取不到当前session时会自动创建一个
		session.invalidate();
		response.sendRedirect("/lyons.eaby/jsp/join/login.jsp");
		
	}

	public void init() throws ServletException
	{
		// Put your code here
	}
}
