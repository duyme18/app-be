package com.duyhd.user.service;

import com.duyhd.user.dto.request.LoginRequest;
import com.duyhd.user.dto.response.JwtResponse;

public interface AuthService {
    JwtResponse login(LoginRequest request);
}
