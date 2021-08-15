package com.java.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AboutUsServlet extends HttpServlet {

    // browser - servlet class
    // browser - filter - servlet class

    // browser -
    // machine IP -
    // process 8080 -
    // application (servlet-hello-world) -
    // filter(s) -
    // servlet
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
        System.out.println(this.getClass()+" service"); // logging

        resp.getWriter().write("about us page");
    }
}
