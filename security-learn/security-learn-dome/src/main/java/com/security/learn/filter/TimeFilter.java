/**
 * 
 */
package com.security.learn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 时间耗时过滤器,在配置类里添加自定义过滤器
 * @author issuser
 *
 */

public class TimeFilter implements Filter {

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
        System.out.println("myfilter init");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		 HttpServletResponse  httpServletResponse = (HttpServletResponse) response;
	     HttpServletRequest httpServletRequest = (HttpServletRequest) request;
	     long start = System.currentTimeMillis();
	     chain.doFilter(httpServletRequest, httpServletResponse);
	     System.out.println("time filter 耗时"+(System.currentTimeMillis() - start));
	     System.out.println("time filter finish");

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("myfilter destroy");
         
	}

}
