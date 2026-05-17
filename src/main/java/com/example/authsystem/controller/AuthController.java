package com.example.authsystem.controller;

import com.example.authsystem.dto.AuthRequest;
import com.example.authsystem.dto.AuthResponse;
import com.example.authsystem.security.JwtUtil;
import com.example.authsystem.service.AuthService;
import com.example.authsystem.service.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping("/register")
    public String register(@RequestBody AuthRequest request) {

        authService.register(request);

        return "User registered successfully";
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody AuthRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        UserDetails userDetails =
                userDetailsService.loadUserByUsername(request.getUsername());

        String token = jwtUtil.generateToken(userDetails.getUsername());

        return new AuthResponse(token);
    }
}