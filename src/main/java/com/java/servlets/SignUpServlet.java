package com.java.servlets;

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

    public static class User{
        private String email;
        private String password;
        private String fullName;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }
    }

    public static Map<String,User> emailUserMapping = new HashMap<>();

    @Override
    public void init() throws ServletException {
      //  super.init();
        User u1 = new User();
        u1.setFullName("u1 user");
        u1.setEmail("u1@gmail.com");
        u1.setPassword("abc@123");
        emailUserMapping.putIfAbsent(u1.getEmail(),u1);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream is = req.getInputStream();
        User e = JacksonUtils.toObject(is,User.class);
        emailUserMapping.putIfAbsent(e.getEmail(),e);

        resp.getWriter().write("user registered "+emailUserMapping.size());
    }
}
