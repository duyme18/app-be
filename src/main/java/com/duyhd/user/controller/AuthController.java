package com.duyhd.user.controller;

import com.duyhd.user.dto.request.LoginRequest;
import com.duyhd.user.dto.response.BaseResponse;
import com.duyhd.user.dto.response.JwtResponse;
import com.duyhd.user.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public BaseResponse<JwtResponse> login(@RequestBody @Valid LoginRequest request) {
        return BaseResponse.of(authService.login(request));
    }

    @PostMapping("/logout")
    public BaseResponse<JwtResponse> logout(@RequestBody @Valid LoginRequest request) {
        return BaseResponse.of(authService.login(request));
    }
}
