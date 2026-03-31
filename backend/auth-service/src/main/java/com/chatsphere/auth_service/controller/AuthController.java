package com.chatsphere.auth_service.controller;

import com.chatsphere.auth_service.dto.SignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController("/auth")
public class AuthController {
    @GetMapping ("/test")
    public ResponseEntity<String> signup(@RequestBody SignUpRequest request){
        return ResponseEntity.ok("SignUp completed Successfully");
    }



}
