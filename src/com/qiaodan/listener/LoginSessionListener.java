package com.qiaodan.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.helloqiaodan.firstweb.PersonInfo;

/**
 * Application Lifecycle Listener implementation class LoginSessionListener
 *
 */
@WebListener
public class LoginSessionListener implements HttpSessionAttributeListener {

	Log log = LogFactory.getLog(getClass());
	Map<String,HttpSession> map = new HashMap<String,HttpSession>();
	
    /**
     * Default constructor. 
     */
    public LoginSessionListener() {
        
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
         String name = arg0.getName();
         if(name.equals("personInfo")){
        	 PersonInfo person = (PersonInfo)arg0.getValue();
        	 if(map.get(person.getAccount()) != null){
        		 HttpSession  session = map.get(person.getAccount());
        		 PersonInfo oldPerson = (PersonInfo)session.getAttribute("personInfo");
        		 log.info("Account:"+oldPerson.getAccount()+" at "+oldPerson.getIp()+" have logined . will be forced to logout.");
        		 session.removeAttribute("personInfo");
        		 session.setAttribute("msg", "Your account have login on the other device.");
        		
        	 }
        	 map.put(person.getAccount(), arg0.getSession());
        	 log.info("Account: "+person.getAccount()+" at "+person.getIp()+" login .");
        		 
         }
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         String name = arg0.getName();
         if(name.equals("personInfo")){
//        	 PersonInfo person = (PersonInfo)arg0.getSession().getAttribute("personInfo");
        	 PersonInfo person = (PersonInfo)arg0.getValue();
        	 map.remove("personInfo");
        	 log.info("Account "+person.getAccount()+" at "+person.getIp()+"zhuxiao. ");
         }
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
         String name = arg0.getName();
         if(name.equals("personInfo")){
        	 PersonInfo oldPerson = (PersonInfo)arg0.getValue();
        	 map.remove(oldPerson.getAccount());
        	 
        	 PersonInfo person = (PersonInfo) arg0.getSession().getAttribute("personInfo");
        	 if(map.get(person.getAccount()) != null){
        		 HttpSession session = map.get(person.getAccount());
        		 session.removeAttribute("personInfo");
        		 session.setAttribute("msg", "You account have logined on other device.");
        	 }
        	 map.put(person.getAccount(), arg0.getSession());
         }
    }
	
}
