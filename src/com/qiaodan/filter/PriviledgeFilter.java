package com.qiaodan.filter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.qiaodan.exception.AccountException;

public class PriviledgeFilter implements Filter {

	private Properties pp = new Properties();
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0; 
		String requestURI = request.getRequestURI().replace(request.getContextPath()+"/", "");
		String action = request.getParameter("action");
		action = action==null?"":action;
		String uri = requestURI+"?action="+action;
		String role = (String)request.getSession(true).getAttribute("role");
		role = role==null?"guest":role;
		boolean authentificated = false;
		for(Object obj:pp.keySet()){
			String key = (String) obj;
			if(uri.matches(key.replace("?", "\\?").replace(".", "\\.").replace("*", ".*"))){
				if(role.equals(pp.get(key))){
					authentificated= true;
					break;
				}
			}
		}
		
		if(!authentificated){
			throw new RuntimeException(new AccountException("You have no right to access this page.Please login first."));
		}
		
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		String file = arg0.getInitParameter("file");
		String realPath = arg0.getServletContext().getRealPath(file);
		try{
			pp.load(new FileInputStream(realPath));
		}catch(Exception e){
			arg0.getServletContext().log("read the priviledge file failed."+ e);
		}

	}

}
