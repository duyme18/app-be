package com.duyhd.app.config;

import com.duyhd.app.constant.RoleEnum;
import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private static final RequestMatcher PUBLIC_APIS = new OrRequestMatcher(
            new AntPathRequestMatcher("/**", HttpMethod.OPTIONS.name()),
            new AntPathRequestMatcher("/swagger-ui/**"),
            new AntPathRequestMatcher("/v3/api-docs/**"),
            new AntPathRequestMatcher("/register"),
            new AntPathRequestMatcher("/login"),
            new AntPathRequestMatcher("/forgot"),
            new AntPathRequestMatcher("/generate-otp"),
            new AntPathRequestMatcher("/validate-otp"),
            new AntPathRequestMatcher("/change-password"),
            new AntPathRequestMatcher("/me")
    );
    private static final List<String> corsMethodAllows = new ArrayList<>(List.of("GET", "PUT", "PATCH", "POST", "DELETE", "OPTIONS"));
    private static final List<String> corsHeaderAllows = new ArrayList<>(List.of("User-Agent", "Origin", "X-Requested-With", "Accept", "Content-Type", "Authorization", "authorization", "Accept-Language", "Dnt", "Access-Control-Allow-Origin", "Referer"));

    private final JwtConverter jwtConverter;

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedMethods(corsMethodAllows);
        configuration.setAllowedHeaders(corsHeaderAllows);
        configuration.setAllowCredentials(false);
        configuration.setMaxAge(10L * 60 * 60);
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setAllowedOriginPatterns(Collections.singletonList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(authorizeRequests -> {

                    authorizeRequests.requestMatchers("/admin/**").hasRole(RoleEnum.ADMIN.name());
                    authorizeRequests.requestMatchers("/customer/**").hasRole(RoleEnum.USER.name());
//                    authorizeRequests.requestMatchers(PUBLIC_APIS).permitAll();

//                    authorizeRequests.requestMatchers(new NegatedRequestMatcher(PUBLIC_APIS)).authenticated();
                    authorizeRequests.dispatcherTypeMatchers(DispatcherType.ERROR).permitAll();
                })
                .oauth2ResourceServer(oauth2Resource ->
                        oauth2Resource.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtConverter))
                )
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
