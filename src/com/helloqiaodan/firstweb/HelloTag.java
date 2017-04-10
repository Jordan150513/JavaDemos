package com.helloqiaodan.firstweb;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport {
	private String name;
	@Override
	public int doEndTag()throws JspException{
		try{
			this.pageContext.getOut().println("hello"+name);
		}catch(IOException e){
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}
	
	public String getName(){
		return name;
	}
}
