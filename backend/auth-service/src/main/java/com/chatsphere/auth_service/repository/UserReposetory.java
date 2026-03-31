package com.chatsphere.auth_service.repository;

import com.chatsphere.auth_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserReposetory extends JpaRepository<User,Long> {

    Optional<User> FindByEmail(String Email);

}
