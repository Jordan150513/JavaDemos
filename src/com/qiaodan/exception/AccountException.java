package com.qiaodan.exception;

public class AccountException extends Exception {
	
	private String message;
	
	public AccountException(){
		
	}
	public AccountException(String message){
		this.message = message;
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
}
