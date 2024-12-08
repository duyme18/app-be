package com.duyhd.app.controller;

import com.duyhd.app.dto.request.LoginRequest;
import com.duyhd.app.dto.response.BaseResponse;
import com.duyhd.app.dto.response.JwtResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.oidc.StandardClaimNames;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HealthCheckController {
    @GetMapping("/me")

    public BaseResponse<UserInfoDto> getGretting(JwtAuthenticationToken auth) {
        return BaseResponse.of(new UserInfoDto(
                auth.getToken().getClaimAsString(StandardClaimNames.PREFERRED_USERNAME),
                auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList()));
    }

    public static record UserInfoDto(String name, List<String> roles) {
    }
}