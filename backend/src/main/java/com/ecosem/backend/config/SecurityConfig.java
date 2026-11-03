package com.ecosem.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Necesario para permitir peticiones POST desde Postman
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**", "/error").permitAll() // Habilita el acceso libre a tus endpoints
                .anyRequest().authenticated()
            );
        return http.build();
    }
}