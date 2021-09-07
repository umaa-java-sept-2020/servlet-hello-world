package com.java.api.service;

import com.java.api.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements IUserService {

    public static Map<String, User> emailUserMapping = new HashMap<>();

    private static UserServiceImpl INSTANCE = new UserServiceImpl();

    public static IUserService getInstance() {
        return INSTANCE;
    }

    private UserServiceImpl() {
        User u1 = new User();
        u1.setFullName("u1 user");
        u1.setEmail("u1@gmail.com");
        u1.setPassword("abc@123");
        emailUserMapping.putIfAbsent(u1.getEmail(), u1);
    }

    @Override
    public int save(User u1) {
        emailUserMapping.putIfAbsent(u1.getEmail(), u1);
        return emailUserMapping.size();
    }

    @Override
    public User getByEmail(String email) {
        return emailUserMapping.get(email);
    }
}
