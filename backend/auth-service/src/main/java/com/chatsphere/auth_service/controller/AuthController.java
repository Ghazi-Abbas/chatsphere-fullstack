package com.chatsphere.auth_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController("/auth")
public class AuthController {
    @GetMapping ("/test")
    public String test(){
        return "Auth Service Running";
    }



}
