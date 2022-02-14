package com.example.authserver.ReQResp;

import java.io.Serializable;

public class AuthResp implements Serializable {
    private final String jwt;

    public AuthResp(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
