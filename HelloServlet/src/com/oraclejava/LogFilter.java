package com.oraclejava;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		String reqUrl = ((HttpServletRequest) req).getRequestURL().toString();
		System.out.println("접속 URL : " + reqUrl + ", 접속일시 : " + new java.util.Date());
		//다음 필터를 호출, 다음필터가 없다면 원래 호출한 서블릿/JSP 호출
		chain.doFilter(req,  resp);
		
	}

	@Override
	public void destroy() {

	}
}
