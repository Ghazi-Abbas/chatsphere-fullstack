package com.chatsphere.auth_service.controller;

import com.chatsphere.auth_service.dto.LoginRequest;
import com.chatsphere.auth_service.dto.SignUpRequest;
import com.chatsphere.auth_service.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController("/auth")
public class AuthController {
      public final AuthService authService;
    @GetMapping ("/signup")
    public ResponseEntity<String> signup(@RequestBody SignUpRequest request){
        return ResponseEntity.ok("SignUp completed Successfully");
    }
    @GetMapping("/login")
    public String login(@RequestBody LoginRequest request){
      return  authService.login( request);

    }



}
