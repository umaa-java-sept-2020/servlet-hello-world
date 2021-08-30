package com.java.servlets;

import com.java.jackson.JacksonUtils;
import com.java.models.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);

        Employee e = new Employee();
        e.setAge(20);
        e.setName("John");
        e.setUuid(UUID.randomUUID().toString());

        String json = JacksonUtils.toJson(e);

        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp);

        InputStream is = req.getInputStream();
        System.out.println("is type: "+is.getClass());
        Employee e = JacksonUtils.toObject(is,Employee.class);
        resp.getWriter().write(e.getName());
    }
}
