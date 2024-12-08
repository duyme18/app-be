package com.duyhd.app.service.impl;

import com.duyhd.app.dto.request.LoginRequest;
import com.duyhd.app.dto.response.JwtResponse;
import com.duyhd.app.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public JwtResponse login(LoginRequest request) {
        return null;
    }
}
