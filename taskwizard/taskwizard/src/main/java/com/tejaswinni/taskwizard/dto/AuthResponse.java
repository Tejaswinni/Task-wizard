package com.tejaswinni.taskwizard.dto;

public class AuthResponse {
    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }

    // Getters
    public String getToken() {
        return token;
    }
}