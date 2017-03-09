package com.fernando.replaceJs;

import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class JavaScriptReplaceVariablesFilter implements Filter {
	
	public void init(FilterConfig config) throws ServletException {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws java.io.IOException, ServletException {
      
		
		PrintWriter out = response.getWriter();
	    CharResponseWrapper responseWrapper = new CharResponseWrapper(
	            (HttpServletResponse) response);
		
		chain.doFilter(request, responseWrapper);
		
		String servletResponse = new String(responseWrapper.toString());
		String resp = servletResponse.replaceAll("\\$\\{myVar\\}", "Oi Fernando");
		
		
		out.write(resp);
		
		
	}

	public void destroy() {
		
	}
}
