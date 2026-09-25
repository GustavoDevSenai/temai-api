package com.terabits.temai.controller;


import com.terabits.temai.dto.LoginRequest;
import com.terabits.temai.dto.LoginResponse;
import com.terabits.temai.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;


    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest request){
        return userService.login(request);
    }


}
