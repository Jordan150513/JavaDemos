package com.helloqiaodan.firstweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestServlet
 */
@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    //返回客户端浏览器接受的文件类型
    private String getAccept(String accept){
    	StringBuffer buffer = new StringBuffer();
    	if(accept.contains("image/gif")) buffer.append("gif文件、 ");
    	if(accept.contains("image/x-xbitmap")) buffer.append("BMP文件、 ");
    	if(accept.contains("image/jpeg")) buffer.append("JPG文件、");
    	if(accept.contains("application/vnd.ms-powerpoint")) buffer.append("PPT文件、 ");
    	if(accept.contains("application/vnd.ms-excel")) buffer.append("EXCEL文件、 ");
    	if(accept.contains("application/vnd.msword")) buffer.append("Word文件、 ");
    	if(accept.contains("application/vnd.ms-powerpoint")) buffer.append("PPT文件、 ");
       return buffer.toString().replace("、  $", "");	//换成以$符号连接的文件名字
    }
    
    
    //返回客户端语言环境名称
    private String getLocale(Locale locale){
    	if(Locale.SIMPLIFIED_CHINESE.equals(locale)) return "简体中文";
    	if(Locale.TRADITIONAL_CHINESE.equals(locale)) return "繁体中文";
    	if(Locale.ENGLISH.equals(locale)) return "英文";
    	if(Locale.JAPANESE.equals(locale)) return "日文";
        return "未知语言环境";	
    }
    
    //自定义的方法类
    //返回ip地址对应的物理地址
//    private String getAddress(String ip){
//    	return IpUtil.getIpAddress(ip);
//    }
    //返回客户端浏览器
    private String getNavigation(String userAgent){
    	if(userAgent.indexOf("TencentTraveler")>0) return "腾讯浏览器";
    	if(userAgent.indexOf("Maxthon")>0) return "Maxthon浏览器";
    	if(userAgent.indexOf("MyIE2")>0) return "MyIE2浏览器";
    	if(userAgent.indexOf("FireFox")>0) return "FireFox浏览器";
    	if(userAgent.indexOf("Safari")>0) return "Safari浏览器";
    	return "未知浏览器";
    }
    
    //返回客户端操作系统
    private String getOS(String userAgent){
    	if(userAgent.indexOf("Windows NT 5.0")>0) return "Windows 2000系统";
    	if(userAgent.indexOf("Linux")>0) return "Linux系统";
    	if(userAgent.indexOf("Unix")>0) return "Unix系统";
    	if(userAgent.indexOf("iOS")>0) return "iOS系统";
    	if(userAgent.indexOf("OS X")>0) return "OS X系统";
    	return "未知的操作系统";
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html");
		
		String authType = request.getAuthType();
		String localAddr = request.getLocalAddr();
		String localName = request.getLocalName();
		int localPort = request.getLocalPort();
		
		Locale locale = request.getLocale();
		String contextPath = request.getContextPath();
		String method = request.getMethod();
		String pathInfo = request.getPathInfo();
		String pathTranslated = request.getPathTranslated();
		String protocol = request.getProtocol();
		String queryString = request.getQueryString();
		String remoteAddr = request.getRemoteAddr();
		int port = request.getRemotePort();
		String remoteUser = request.getRemoteUser();
		String requestSessionId = request.getRequestedSessionId();
		String requestURI = request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();
		String scheme = request.getScheme();
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		String servletPath = request.getServletPath();
		Principal userPrincipal = request.getUserPrincipal();
		
		String accept = request.getHeader("accept");
		String referer = request.getHeader("referer");
		String userAgent = request.getHeader("user-agent");
		String serverInfo = request.getServletContext().getServerInfo();
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<head><title>Information Serverlet</title><meta chartSet=\"UTF-8\"></head>");
		out.println("<style>body,font,td,div{font-size:12px;line-height:18px;}</style>");
		out.println("<Body>");
		
		out.println("<b>your ip is</b>"+remoteAddr);
		out.println("<b>locate </b>"+"getAddress(remoteAddr)");
		out.println("<b>you use</b>"+getOS(userAgent)+"<b>operate system</b>"+getNavigation(userAgent));
		out.println("<b>.you use </b>"+getLocale(locale)+".</br>");
		out.println("<b>The server ip is :</b>"+localAddr+"<b> locate :</b>"+"getAddress(localAddr)"+"<b>,the server use </b>"+serverPort+"<b>port ,your brosewer use </b>"+port+"<b>port to access this page</b>");
		out.println("<b>The Server software is :</b>"+serverInfo+"<b>. The serverName is :</b>"+localName+".</br>");		
	
		out.println("<b>Your browerse accept the types :</b>"+getAccept(accept)+"<b>of the files</b>");
		out.println("You come frome "+referer+"to access this page");
		out.println("The protocol you use is :"+protocol+". The protocol header is :"+scheme+"The serverName is :"+serverName+"The URI you access is :"+requestURI);
		out.print(" The Path of the servlet is :"+servletPath+"The class of this sevlet is "+this.getClass().getName());
		out.println("The root path in the disk of this software is :"+this.getServletContext().getRealPath("")+"The relative net path of this is :"+contextPath);
		out.println("<br/>");
		out.println("<br/><br/> <a href="+requestURI+">Click to refresh</a>");
		
		out.println("</Body>");
		out.println("</HTML>");
		
		out.println("");
		out.println("");
		out.println("");
	}
	//访问路径：
//http://localhost:8080/01-firstWeb/servlet/RequestServlet
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
