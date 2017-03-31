package com.qiaodan.listener;

import java.io.Serializable;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PersonInfo implements HttpSessionActivationListener, HttpSessionBindingListener, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Log log = LogFactory.getLog(getClass());
	private String name;
	private Date dateCreated;
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public void setDateCreated(Date date){
		this.dateCreated = date;
	}
	public Date getDateCreated(){
		return this.dateCreated;
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		HttpSession session = arg0.getSession();
		String name = arg0.getName();
		log.info(this+" is bingding to session\""+session.getId()+"\" zhi"+ name+" attribute");
		this.setDateCreated(new Date());
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		HttpSession session = arg0.getSession();
		String name = arg0.getName();
		log.info(this+" is unbingding from session\""+session.getId()+"\" zhi"+ name+" attribute");

	}

	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		log.info(this+" is successfully loaded from disk. Sessionid:"+session.getId());
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		log.info(this+" is will be stored to the disk. Sessionid:"+session.getId());

	}
	
	@Override
	public String toString(){
		return "PersonInfo+("+name+")";
	}

}
