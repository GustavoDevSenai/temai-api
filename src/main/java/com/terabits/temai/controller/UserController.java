package com.terabits.temai.controller;


import com.terabits.temai.dto.CreateUserRequest;
import com.terabits.temai.entity.User;
import com.terabits.temai.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;


    public UserController(UserService userService){

        this.userService = userService;

    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(
            @RequestBody @Valid CreateUserRequest request
    ){

        return userService.create(request);

    }

}