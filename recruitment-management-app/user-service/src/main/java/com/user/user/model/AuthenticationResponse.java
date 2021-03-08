package com.user.user.model;

public class AuthenticationResponse {

    private final String jwt;

    public String getJwt() {
        return this.jwt;
    }

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;

    }

}
