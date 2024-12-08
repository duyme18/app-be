package com.duyhd.app.controller;

import com.duyhd.app.dto.request.LoginRequest;
import com.duyhd.app.dto.response.BaseResponse;
import com.duyhd.app.dto.response.JwtResponse;
import com.duyhd.app.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
