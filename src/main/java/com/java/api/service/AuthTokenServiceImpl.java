package com.java.api.service;

import com.java.api.models.TokenInfo;
import com.java.jackson.JacksonUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

public class AuthTokenServiceImpl implements IAuthTokenService {

    private static IAuthTokenService INSTANCE = new AuthTokenServiceImpl();

    public static IAuthTokenService getInstance() {
        return INSTANCE;
    }

    @Override
    public String generateToken(String email) {
        int N = 5;
        long currentTimeMs = System.currentTimeMillis();
        long nextMsAfter_N_Minutes = currentTimeMs + TimeUnit.MINUTES.toMillis(N);

        System.out.println("diff ms " + (nextMsAfter_N_Minutes - currentTimeMs));
        TokenInfo tokenInfo = new TokenInfo(email, nextMsAfter_N_Minutes);
        String rawToken = JacksonUtils.toJson(tokenInfo);
        String encodedToken = Base64.getEncoder().encodeToString(rawToken.getBytes(StandardCharsets.UTF_8));
        return encodedToken;
    }

    @Override
    public TokenInfo validateToken(String encodedToken) {
        byte[] rawTokenBytes = Base64.getDecoder().decode(encodedToken.getBytes(StandardCharsets.UTF_8));
        String rawToken = new String(rawTokenBytes);
        TokenInfo tokenInfo = JacksonUtils.toObject(rawToken, TokenInfo.class);
        long expireAt = tokenInfo.getExpireAt(); // 8:05, 8:07
        // 100 : generated token
        // 105 :  expireAt
        // 104 : valid
        // 107 : invalid
        if (expireAt - System.currentTimeMillis() <= 0)
            return null;
        return tokenInfo;
    }

    public static void main(String[] args) {
        long currentTimeMs = System.currentTimeMillis();
        System.out.println(currentTimeMs);
        long nextMs = currentTimeMs + TimeUnit.MINUTES.toMillis(5);

        // 1second = 1000 ms
        // 300 second = 300 000 ms
        System.out.println(nextMs - currentTimeMs);


        IAuthTokenService authTokenService = getInstance();
        String token = authTokenService.generateToken("abc@gmail.com");
        TokenInfo tokenInfo = authTokenService.validateToken(token);

        System.out.println(tokenInfo);
    }
}
