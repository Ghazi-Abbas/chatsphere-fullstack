package com.chatsphere.auth_service.service;

import com.chatsphere.auth_service.dto.LoginRequest;
import com.chatsphere.auth_service.dto.SignUpRequest;
import com.chatsphere.auth_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import com.chatsphere.auth_service.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
@Override
    public String signup(SignUpRequest request){
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("User already exixts");
        }

//        User user= new User();
//        user.setEmail(request.getEmail());
//        user.setName(request.getName());
//        user.setPasswordHash(request.getPassword());

    String hashedPassword =passwordEncoder.encode(request.getPassword());

    // with help of Builder
    User user= User.builder()
            .name(request.getName())
            .email(request.getEmail())
            .passwordHash(hashedPassword)
            .build();

        userRepository.save(user);
        return "User Registered Sussessfully";
    }

    @Override
    public String login(LoginRequest request){
     User user=userRepository.findByEmail(request.getEmail())
             .orElseThrow(()-> new RuntimeException("User not found"));
     if(!passwordEncoder.matches(request.getPassword(),user.getPasswordHash())){
         throw new RuntimeException("Invalid Password");
     }
     return "Login is successful!";
    }
}
