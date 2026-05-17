package com.example.authsystem.service;

import com.example.authsystem.dto.AuthRequest;
import com.example.authsystem.model.Role;
import com.example.authsystem.model.User;
import com.example.authsystem.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public void register(AuthRequest request) {

        User user = new User();

        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole(Role.USER);

        repository.save(user);
    }
}