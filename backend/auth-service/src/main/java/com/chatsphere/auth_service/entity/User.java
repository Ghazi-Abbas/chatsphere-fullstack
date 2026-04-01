package com.chatsphere.auth_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name="users",
        indexes={
        @Index(name="idx_email",columnList="email")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false,unique = true)
    String email;

    @Column(nullable=false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Boolean isActive;

    private Boolean isEmailVerified;

    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private LocalDateTime lastLoginAT;

    @PrePersist
    protected void onCreate(){
        this.createdAt=LocalDateTime.now();
        this.isActive=true;
        this.isEmailVerified=false;
    }

    @PreUpdate
    protected void onUpdate(){
        this.updateAt=LocalDateTime.now();
    }
}
