package com.qiaodan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogFilter implements Filter {

	private Log log = LogFactory.getLog(this.getClass());
	private String filterName;
	
	@Override
	public void destroy() {
		log.info("close filter"+filterName);
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		long startTime = System.currentTimeMillis();
		String requestURI =request.getRequestURI();
		requestURI = request.getQueryString()==null?request.getRequestURI():(requestURI+"?"+request.getQueryString());
		
		arg2.doFilter(request, response);
		long endTime = System.currentTimeMillis();
		log.info(request.getRemoteAddr()+" access to The "+requestURI+" last times: "+(endTime-startTime)+" ms.");

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		filterName = arg0.getFilterName();
		log.info("start filter:"+filterName);
	}

}
