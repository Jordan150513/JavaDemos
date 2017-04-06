package com.qiaodan.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Application Lifecycle Listener implementation class MyRequestLintener
 *
 */
@WebListener
public class MyRequestLintener implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public MyRequestLintener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent arg0)  { 
         
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent arg0)  { 
         HttpServletRequest request = (HttpServletRequest) arg0.getServletRequest();
         HttpSession session = request.getSession(true);
         session.setAttribute("ip", request.getRemoteAddr());
         
         String uri = request.getRequestURI();
         String[] suffix = {".html",".do",".jsp",".action"};
         for(int i = 0;i<suffix.length;i++){
        	 if(uri.endsWith(suffix[i])) break;
        	 if(i==suffix.length-1) return;
         }
         
         Integer activeTimes = (Integer) session.getAttribute("activeTimes");
         if(activeTimes==null){
        	 activeTimes = 0;
         }
         session.setAttribute("activeTimes", activeTimes+1);
    }
	
}
