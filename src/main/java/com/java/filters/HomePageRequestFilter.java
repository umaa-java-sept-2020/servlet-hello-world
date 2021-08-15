package com.java.filters;

import javax.servlet.*;
import java.io.IOException;

public class HomePageRequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       // only time
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
         // every request if url matches (/*)
        System.out.println("before: "+this.getClass());
        // validate request, modify request

        filterChain.doFilter(servletRequest, servletResponse); // next filter , servlet

        // validate / modify response
        System.out.println("after: "+this.getClass());
    }

    @Override
    public void destroy() {

        // one time
    }
}
