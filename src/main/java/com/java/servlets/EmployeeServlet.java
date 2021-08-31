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

    // GET can carry the body

    // GET me movie by id (object)
    // GET all movies (array)
    // GET by certain conditions (array)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);

        Employee e = new Employee();
        e.setAge(20);
        e.setName("John");
        e.setUuid(UUID.randomUUID().toString());

        String json = JacksonUtils.toJson(e);

     //   resp.getWriter().write(json);

        InputStream is = req.getInputStream();
        System.out.println("is type: "+is.getClass());
        e = JacksonUtils.toObject(is,Employee.class);
        resp.getWriter().write(e.getName()+" GET");
    }

    // CREATE (body)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp);

        InputStream is = req.getInputStream();
        System.out.println("is type: "+is.getClass());
        Employee e = JacksonUtils.toObject(is,Employee.class);
        resp.getWriter().write(e.getName());
    }

    // UPDATE (body, id)
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPut(req, resp);

        String id = req.getParameter("empId");
        InputStream is = req.getInputStream();
        System.out.println("is type: "+is.getClass());
        Employee e = JacksonUtils.toObject(is,Employee.class);
        resp.getWriter().write(e.getName()+" PUT "+id);
    }

    // id
    // DELETE can carry the body.
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doDelete(req, resp);
        String id = req.getParameter("empId");
        InputStream is = req.getInputStream();
        System.out.println("is type: "+is.getClass());
        Employee e = JacksonUtils.toObject(is,Employee.class);
        resp.getWriter().write(e.getName()+" DELETE "+id);
    }
}
