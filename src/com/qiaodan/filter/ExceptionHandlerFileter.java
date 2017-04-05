package com.qiaodan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import com.qiaodan.exception.AccountException;
import com.qiaodan.exception.BusinessException;


public class ExceptionHandlerFileter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		try{
			arg2.doFilter(arg0, arg1);
			
		}catch(Exception e){
			Throwable rootCause = e;
			while(rootCause.getCause()!=null){
				rootCause = rootCause.getCause(); 
			}
			
			String message = rootCause.getMessage();
			message = message==null?"Exception!"+rootCause.getClass().getName():message;
			arg0.setAttribute("message", message);
			arg0.setAttribute("e", e);
			if(rootCause instanceof AccountException){
				// Account Exception
				arg0.getRequestDispatcher("/accountException.jsp").forward(arg0,arg1);
			}else if(rootCause instanceof BusinessException){
				// Business Exception
				arg0.getRequestDispatcher("/businessException.jsp").forward(arg0, arg1);
			}else{
				// normal exception
//				arg0.getRequestDispatcher("/exception.jsp").forward(arg0, arg1);
			}
			}
		}

	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
