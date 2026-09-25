package com.terabits.temai.service;


import com.terabits.temai.dto.*;
import com.terabits.temai.entity.User;
import com.terabits.temai.exception.BusinessException;
import com.terabits.temai.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


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

    public UserResponse create(CreateUserRequest request){

        if(userRepository.existsByPhone(request.phone())){
            throw new BusinessException("Telefone já cadastrado");
        }

        User user = new User();

        user.setName(request.name());

        user.setPhone(request.phone());


        user.setPassword(
                passwordEncoder.encode(request.password())
        );

        User savedUser = userRepository.save(user);

        return new UserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getPhone(),
                savedUser.getCreatedAt(),
                savedUser.getUpdatedAt()
        );
    }


    public LoginResponse login(LoginRequest request){


        Optional<User> userOptional = userRepository.findByPhone(request.phone());


        if(userOptional.isEmpty()){
            throw new RuntimeException("Telefone ou senha invalidos");

        }

        User user = userOptional.get();


        if(!passwordEncoder.matches(request.password(),user.getPassword())){
            throw new RuntimeException("Senha inválida");
        }



        return new LoginResponse(
                user.getId(),
                user.getName(),
                user.getPhone()
        );

    }
}
