package com.qiaodan.listener;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ListenerTest implements HttpSessionListener,ServletContextListener {

	Log log = LogFactory.getLog(getClass());
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		log.info("create a new session,id is"+session.getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		log.info("destory a new session,id is"+session.getId());
	}
	@Override
		public void contextInitialized(ServletContextEvent arg0){
			ServletContext servletContext = arg0.getServletContext();
			log.info("will launch servlet:"+servletContext.getContextPath());
		}
	@Override
		public void contextDestroyed(ServletContextEvent arg0){
			ServletContext servletContext = arg0.getServletContext();
			log.info("will close servlet:"+servletContext.getContextPath());
		}
// ServletRequestListener listener can not be solved 
//	@Override
//	public void requestDestroyed(ServletRequestEvent arg0) {
//		HttpServletRequest request = (HttpServletRequest)arg0;
//		long time = System.currentTimeMillis()-(long)request.getAttribute("dateCreated");
//		log.info(request.getRemoteAddr() + "request is finished. during  "+time + "ms");
//		
//	}
//
//	@Override
//	public void requestInitialized(ServletRequestEvent arg0) {
//		HttpServletRequest request = (HttpServletRequest) arg0;
//		String uri = request.getRequestURI();
//		uri = request.getQueryString()==null?uri:request.getQueryString();
//		request.setAttribute("dateCreated:", System.currentTimeMillis());
//		log.info("IP:"+request.getRemoteAddr()+" request "+uri);
//	}
					
		}
