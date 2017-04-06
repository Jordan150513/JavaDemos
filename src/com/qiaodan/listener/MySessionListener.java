package com.qiaodan.listener;

import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import com.helloqiaodan.firstweb.ApplicationConstants;

/**
 * Application Lifecycle Listener implementation class MySessionListener
 *
 */
@WebListener
public class MySessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public MySessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         HttpSession session = arg0.getSession();
         ApplicationConstants.SESSION_MAP.put(session.getId(), session);
         ApplicationConstants.TOTAL_HISTORY_COUNT++;
         if(ApplicationConstants.SESSION_MAP.size()>ApplicationConstants.MAX_ONLINE_COUNT){
        	 ApplicationConstants.MAX_ONLINE_COUNT = ApplicationConstants.SESSION_MAP.size();
        	 ApplicationConstants.MAX_ONLINE_COUNT_Date = new Date();
         }
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	// remove the session
         HttpSession session = arg0.getSession();
         ApplicationConstants.SESSION_MAP.remove(session.getId());
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
         if(arg0.getName().equals("personInfo")){
        	 ApplicationConstants.CURRENT_LOGIN_COUNT++;
        	 HttpSession session = arg0.getSession();
        	 
        	 //if this account is login on the other device then the other login is invalid
        	 for(HttpSession sess:ApplicationConstants.SESSION_MAP.values()){
        		 if(arg0.getValue().equals(sess.getAttribute("personInfo")) && sess.getId() != session.getId()){
        			 sess.invalidate();
        		 }
        	 }
         }
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         if(arg0.getName().equals("personInfo")){
        	 ApplicationConstants.CURRENT_LOGIN_COUNT--;
        	 
         }
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
         if(arg0.getName().equals("personInfo")){
        	 HttpSession session = arg0.getSession();
        	 for(HttpSession sess:ApplicationConstants.SESSION_MAP.values()){
        		 if(sess.getAttribute("personInfo").equals(arg0.getValue()) && sess.getId() != session.getId()){
        			 sess.invalidate();
        		 }
        	 }
         }
    }
	
}
