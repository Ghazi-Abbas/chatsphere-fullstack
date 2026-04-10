package com.chatsphere.auth_service.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.sql.rowset.serial.SerialException;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private final JwtService jwtService;

    public JwtFilter(JwtService jwtService){
        this.jwtService=jwtService;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse responce,
                                    FilterChain filterChain)
        throws ServletException, IOException{
        String authHeader =request.getHeader("Authorization");

        if(authHeader != null && authHeader.startsWith("Bearer ")){
            String token =authHeader.substring(7);
            String email= jwtService.extractEmail(token);
        }

        filterChain.doFilter(request,responce);

    }


}
