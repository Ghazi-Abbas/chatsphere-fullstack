package com.chatsphere.auth_service.service;

import com.chatsphere.auth_service.dto.LoginRequest;
import com.chatsphere.auth_service.dto.SignUpRequest;

public interface AuthService {

    public String signup(SignUpRequest request);
    public String login(LoginRequest request);

}
