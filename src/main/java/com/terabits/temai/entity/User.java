package com.terabits.temai.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, length = 100)
    private String name;


    @Column(nullable = false, unique = true, length = 20)
    private String phone;


    @Column(length = 150)
    private String email;


    @Column(length = 20)
    private String whatsapp;


    @Column(nullable = false)
    private String password;


    @Column(name = "created_at")
    private LocalDateTime createdAt;


    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @PrePersist
    public void prePersist(){

        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();

    }


    @PreUpdate
    public void preUpdate(){

        updatedAt = LocalDateTime.now();

    }

}