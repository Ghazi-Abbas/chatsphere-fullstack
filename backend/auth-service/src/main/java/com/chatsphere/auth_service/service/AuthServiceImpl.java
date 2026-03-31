package com.chatsphere.auth_service.service;

import com.chatsphere.auth_service.dto.SignUpRequest;
import com.chatsphere.auth_service.entity.AuthProvider;
import com.chatsphere.auth_service.entity.Role;
import com.chatsphere.auth_service.repository.UserReposetory;
import lombok.RequiredArgsConstructor;
import com.chatsphere.auth_service.entity.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserReposetory userRepository;
@Override
    public String signup(SignUpRequest request){
        if(userRepository.FindByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("User already exixts");
        }

//        User user= new User();
//        user.setEmail(request.getEmail());
//        user.setName(request.getName());
//        user.setPasswordHash(request.getPassword());

    // with help of Builder
    User user= User.builder()
            .name(request.getName())
            .email(request.getEmail())
            .passwordHash(request.getPassword())
            .build();

        userRepository.save(user);
        return "User Registered Sussessfully";
    }
}
