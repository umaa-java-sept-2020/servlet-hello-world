package com.java.api.models;

public class TokenInfo {

    private String email;
    private Long expireAt;


    public TokenInfo(String email, Long expireAt) {
        this.email = email;
        this.expireAt = expireAt;
    }

    public TokenInfo() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Long expireAt) {
        this.expireAt = expireAt;
    }
}
