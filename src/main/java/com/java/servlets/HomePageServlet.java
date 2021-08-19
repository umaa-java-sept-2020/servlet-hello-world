package com.java.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomePageServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  super.service(req, resp);

        Thread currentThread = Thread.currentThread();
        System.out.println("current thread: "+currentThread);
        System.out.println(this.getClass()+" service");
        resp.getWriter().write("home page");
    }
}
