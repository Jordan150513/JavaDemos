package com.helloqiaodan.firstweb;

import java.io.Serializable;
import java.util.Date;

public class PersonInfo implements Serializable {

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String account;
	private String ip;
	private Date loginDate;

	@Override
	public boolean equals(Object obj){
		if(obj==null||!(obj instanceof PersonInfo)){
			return false;
		}
		return account.equalsIgnoreCase(((PersonInfo)obj).getAccount());
	}
}
