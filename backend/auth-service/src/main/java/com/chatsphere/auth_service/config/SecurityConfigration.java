package com.chatsphere.auth_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                //Cross-Site Request Forgery
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth->auth
                        .anyRequest().permitAll()
                );
        return http.build();
    }

}
