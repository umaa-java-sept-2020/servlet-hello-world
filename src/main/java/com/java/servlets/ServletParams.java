package com.java.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletParams extends HttpServlet {

    @Override
    public void init() throws ServletException {
        //   super.init();
        displayParams("init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  super.doGet(req, resp);
        displayParams("doGet");
        resp.getWriter().println("watch logs for params");
    }

    @Override
    public void destroy() {
        // super.destroy();
        displayParams("destroy");
    }

    private void displayParams(String methodName) {
        System.out.println("displaying for methodName: " + methodName);
        // servlet config: one for each servlet
        String x = getServletConfig().getInitParameter("x_servlet");
        String y = getServletConfig().getInitParameter("y_servlet");

        // servlet context: one per application (.war)
        String a = getServletConfig().getServletContext().getInitParameter("a_context");
        String b = getServletConfig().getServletContext().getInitParameter("b_context");

        System.out.printf("x=%s,y=%s,a=%s,b=%s", x, y, a, b);
        System.out.println();
    }
}
