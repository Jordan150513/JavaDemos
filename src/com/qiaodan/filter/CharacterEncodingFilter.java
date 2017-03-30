package com.qiaodan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {

	private String characterEncoding;
	private boolean enable;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		if(enable||characterEncoding!=null){
			arg0.setCharacterEncoding(characterEncoding);
			arg1.setCharacterEncoding(characterEncoding);
		}
		arg2.doFilter(arg0,arg1);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		characterEncoding = arg0.getInitParameter("characterEncoding");
		enable = "true".equalsIgnoreCase(arg0.getInitParameter("enable").trim());
System.out.println(characterEncoding+" "+enable);
	}

}
