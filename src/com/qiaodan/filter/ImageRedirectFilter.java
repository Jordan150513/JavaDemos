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

public class ImageRedirectFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		String referer = request.getHeader("referer");
		System.out.println(referer); // is null i know why is null
		//it show who referer this resource 链接来源的地址 我是直接访问图片的，so referer is null
		System.out.println(request.getServerName()); // is locallhost
		if(referer==null||!referer.contains(request.getServerName())){
			// if is come from the other website
			request.getRequestDispatcher("/image/goods/001.jpg").forward(request, response);
		}else{
			arg2.doFilter(request,response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
