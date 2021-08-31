package com.java.servlets;

import com.java.jackson.JacksonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  super.doPost(req, resp);
        // email & password
        InputStream is = req.getInputStream();
        SignUpServlet.User loginUserRequest = JacksonUtils.toObject(is, SignUpServlet.User.class);

        SignUpServlet.User registeredUser = SignUpServlet.emailUserMapping.get(loginUserRequest.getEmail());

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

    public static String getAuthHeader(SignUpServlet.User user)
    {
        String email = user.getEmail();
        // some logic
        return email;
    }
}
