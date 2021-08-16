package com.java.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * this executes when a request comes and processed irrespective of URL pattern of the request.
 */
public class RequestContextListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("request destroyed "+this.getClass());
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("request initialized "+this.getClass());
    }
}
