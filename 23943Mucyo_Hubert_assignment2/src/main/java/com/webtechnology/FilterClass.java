package com.webtechnology;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebFilter("/home.html")
public class FilterClass extends HttpFilter implements Filter {

	 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	            throws IOException, ServletException {
	        if (request instanceof HttpServletRequest) {
	            HttpServletRequest httpRequest = (HttpServletRequest) request;

	            HttpSession session = httpRequest.getSession(false); 

	            if (session != null) {
	                String Email = (String) session.getAttribute("email");

	                if (Email != null && !Email.isEmpty()) {
	                    chain.doFilter(request, response);
	                    return;
	                }
	            }
	        }

	        request.getRequestDispatcher("index.html").forward(request, response);
	    }
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
