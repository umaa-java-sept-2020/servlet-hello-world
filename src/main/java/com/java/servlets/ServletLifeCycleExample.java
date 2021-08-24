package com.java.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletLifeCycleExample extends HttpServlet {

    @Override
    public void init() throws ServletException {
      //  super.init();
        System.out.println("method executed: init()");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.service(req, resp);
        System.out.println("method executed: service()");

        resp.getWriter().write("service method response");
    }

    @Override
    public void destroy() {
        //super.destroy();
        System.out.println("method executed: destroy()");
    }
}
