package com.java.api.controller;

import com.java.api.models.User;
import com.java.api.service.AuthTokenServiceImpl;
import com.java.api.service.IAuthTokenService;
import com.java.api.service.IUserService;
import com.java.api.service.UserServiceImpl;
import com.java.jackson.JacksonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class LoginServlet extends HttpServlet {

    private IUserService userService;
    private IAuthTokenService authTokenService;
    @Override
    public void init() throws ServletException {
        //  super.init();
        userService = UserServiceImpl.getInstance();
        authTokenService = AuthTokenServiceImpl.getInstance();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  super.doPost(req, resp);
        // email & password
        InputStream is = req.getInputStream();
        User loginUserRequest = JacksonUtils.toObject(is, User.class);

        User registeredUser = userService.getByEmail(loginUserRequest.getEmail());

        boolean loginSuccess = false;
        if (registeredUser != null) {
            if (loginUserRequest.getPassword().equals(registeredUser.getPassword())) {
                loginSuccess = true;
            }
        }
        if (loginSuccess) {
            resp.setHeader("Authorization",getAuthHeader(registeredUser));
            resp.getWriter().write("login success");
        } else {
            resp.getWriter().write("login failed");
        }

    }

    private String getAuthHeader(User user)
    {
        String email = user.getEmail();
        // some logic
        return authTokenService.generateToken(email);
    }
}
