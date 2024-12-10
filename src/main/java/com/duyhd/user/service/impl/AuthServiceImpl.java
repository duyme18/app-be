package com.duyhd.user.service.impl;

import com.duyhd.user.dto.request.LoginRequest;
import com.duyhd.user.dto.response.JwtResponse;
import com.duyhd.user.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public JwtResponse login(LoginRequest request) {
        return null;
    }
}
