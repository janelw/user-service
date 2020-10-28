package com.user.user.model;

public class AuthenticationResponse {

    private final String jwt;

    // private final String username;

    public String getJwt() {
        return this.jwt;
    }

    // public String getUsername(){
    //     return this.username;
    // }


    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
        // this.username = username;
    }

    
}
