package com.example.authsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AuthRequest {

    @NotBlank(message = "Username cannot be empty")
    @Size(min = 3, max = 20, message = "Username must have 3-20 characters")
    private String username;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 4, max = 50, message = "Password must have at least 4 characters")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}