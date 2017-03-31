package com.qiaodan.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SessionAttributeListener implements HttpSessionAttributeListener {

	Log log = LogFactory.getLog(getClass()); // get the log recoder
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		HttpSession session = arg0.getSession();
		String name = arg0.getName();
		log.info("the new creat session attribute: "+ name+" value is "+arg0.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		HttpSession session = arg0.getSession();
		String name = arg0.getName();
		log.info("the session attribute: "+ name+" value is "+arg0.getValue()+"will be removed.");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		HttpSession session = arg0.getSession();
		String name = arg0.getName();
		log.info("the session attribute: "+ name+" old value is "+arg0.getValue()+"will be replaced by new value."+session.getAttribute(name));

	}

}
