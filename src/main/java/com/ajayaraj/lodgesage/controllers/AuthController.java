package com.ajayaraj.lodgesage.controllers;

import com.ajayaraj.lodgesage.dtos.UserDto;
import com.ajayaraj.lodgesage.mappers.UserMapper;
import com.ajayaraj.lodgesage.models.User;
import com.ajayaraj.lodgesage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public AuthController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User registeredUser = userService.register(user);
        return ResponseEntity.ok(userMapper.toDto(registeredUser));
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        return userService.login(user);
    }
}
