package com.example.ontap.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomAuthenticationEntryPoint customEntryPoint;

    public SecurityConfig(CustomAuthenticationEntryPoint customEntryPoint) {
        this.customEntryPoint = customEntryPoint;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Tắt CSRF (nếu cần thiết)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/register", "/api/auth/login").permitAll() // Cho phép không cần đăng nhập
                        .anyRequest().authenticated() // Các request khác cần xác thực
                )
                .httpBasic(Customizer.withDefaults()) // Hỗ trợ basic auth (nếu cần)
//                .formLogin(Customizer.withDefaults()) // ✅ Chuyển sang form login
                .build();
    }
}
