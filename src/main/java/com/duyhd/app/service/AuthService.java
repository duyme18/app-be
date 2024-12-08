package com.duyhd.app.service;

import com.duyhd.app.dto.request.LoginRequest;
import com.duyhd.app.dto.response.JwtResponse;

public interface AuthService {
    JwtResponse login(LoginRequest request);
}
