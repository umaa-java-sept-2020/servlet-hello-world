package com.java.filters;

import javax.servlet.*;
import java.io.IOException;

public class FilterParams implements Filter {

    private FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       // only time
        this.filterConfig = filterConfig;
        displayParams("init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
         // every request if url matches (/*)
        System.out.println("before: "+this.getClass());
        // validate request, modify request

        filterChain.doFilter(servletRequest, servletResponse); // next filter , servlet

        // validate / modify response
        displayParams("doFilter()");
        System.out.println("after: "+this.getClass());
    }

    @Override
    public void destroy() {

        // one time
        displayParams("destroy()");
    }

    private void displayParams(String methodName) {
        System.out.println("displaying for methodName: " + methodName);
        // filter config: one for each filter
        String x = this.filterConfig.getInitParameter("x_filter");
        String y = this.filterConfig.getInitParameter("y_filter");

        // servlet context: one per application (.war)
        String a = this.filterConfig.getServletContext().getInitParameter("a_context");
        String b = this.filterConfig.getServletContext().getInitParameter("b_context");

        System.out.printf("x=%s,y=%s,a=%s,b=%s", x, y, a, b);
        System.out.println();
    }
}
