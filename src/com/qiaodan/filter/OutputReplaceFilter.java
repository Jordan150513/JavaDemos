package com.qiaodan.filter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import com.helloqiaodan.firstweb.HttpCharacterResponseWarpper;
/**
 * Servlet Filter implementation class OutputReplaceFilter
 */
@WebFilter("/OutputReplaceFilter")
public class OutputReplaceFilter implements Filter {

	private Properties pp = new Properties();
	
    /**
     * Default constructor. 
     */
    public OutputReplaceFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpCharacterResponseWarpper response2 = new HttpCharacterResponseWarpper((HttpServletResponse)response);
		
		// pass the request along the filter chain
		chain.doFilter(request, response2);
		
		String outPut = response2.getCharArrayWriter().toString();
		
		for(Object obj:pp.keySet()){
			String key = (String)obj;
			outPut = outPut.replace(key, pp.getProperty(key));
		}
		PrintWriter out = response.getWriter();
		out.write(outPut);
		out.println("<!-- Generate at "+new java.util.Date()+"-->");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		String file = fConfig.getInitParameter("file");
		String realPath = fConfig.getServletContext().getRealPath(file);
		try{
			pp.load(new FileInputStream(realPath));
		}catch(IOException e){}
	}

}
