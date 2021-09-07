package com.java.api.service;

import com.java.api.models.TokenInfo;

public interface IAuthTokenService {

    public String generateToken(String email);
    public TokenInfo validateToken(String token);
}
