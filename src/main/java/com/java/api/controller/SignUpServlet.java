package com.java.api.controller;

import com.java.api.models.User;
import com.java.api.service.IUserService;
import com.java.api.service.UserServiceImpl;
import com.java.jackson.JacksonUtils;
import com.java.models.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

// registration
//
public class SignUpServlet extends HttpServlet {



    private IUserService userService;

    @Override
    public void init() throws ServletException {
      //  super.init();
        userService = UserServiceImpl.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream is = req.getInputStream();
        User e = JacksonUtils.toObject(is,User.class);
        int size = userService.save(e);

        resp.getWriter().write("user(s) registered "+size);
    }
}
