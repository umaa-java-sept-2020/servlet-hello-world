package com.java.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class QueryStringServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  super.doGet(req, resp);
        accessAsKeyValue(req);
        accessUsingMap(req);

        resp.getWriter().write("doGet executed");
    }

    private void accessAsKeyValue(HttpServletRequest req) {
        System.out.println("access as key_value");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String age = req.getParameter("age");

        System.out.println("id= " + id + " name= " + name + " age=" + age);
    }

    private void accessUsingMap(HttpServletRequest req) {
        System.out.println("access using map");
        Map<String, String[]> map = req.getParameterMap();
        for (Map.Entry<String, String[] > entry : map.entrySet()) {
            System.out.println("key: " + entry.getKey());
            System.out.println("values: "+ entry.getValue());
            System.out.println("values: "+ Arrays.toString(entry.getValue()));
        }
    }
}
