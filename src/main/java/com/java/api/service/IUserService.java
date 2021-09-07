package com.java.api.service;

import com.java.api.models.User;

public interface IUserService {

    int save(User u);
    User getByEmail(String email);
}
