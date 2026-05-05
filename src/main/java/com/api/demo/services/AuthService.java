package com.api.demo.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.api.demo.repositories.UserRepository;

import lombok.AllArgsConstructor;

import com.api.demo.models.User;

@AllArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;

    public User getCurrentUser() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        var userId = (Long) auth.getPrincipal();
        return userRepository.findById(userId).orElse(null);
    }

}
