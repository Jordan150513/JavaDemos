package com.qiaodan.exception;

public class BusinessException extends Exception {
	private String message;

	public BusinessException(){
		
	}
	public BusinessException(String message){
		this.message= message;	
	}

	public void setMessage(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
}
