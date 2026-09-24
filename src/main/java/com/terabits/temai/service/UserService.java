package com.terabits.temai.service;


import com.terabits.temai.dto.CreateUserRequest;
import com.terabits.temai.entity.User;
import com.terabits.temai.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ){

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    public User create(CreateUserRequest request){

        if(userRepository.existsByPhone(request.phone())){
            throw new RuntimeException("Telefone já cadastrado");
        }

        User user = new User();

        user.setName(request.name());

        user.setPhone(request.phone());


        user.setPassword(
                passwordEncoder.encode(request.password())
        );


        user.setCreatedAt(
                LocalDateTime.now()
        );


        user.setUpdatedAt(
                LocalDateTime.now()
        );

        return userRepository.save(user);
    }
}
