package com.security.security_jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.security_jwt.Repository.UserRepository;
import com.security.security_jwt.model.User;
import com.security.security_jwt.service.UserService;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepo;

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody User user) throws Exception {

        return userService.register(user);

    }

    @GetMapping("allUser")
    public ResponseEntity<List<User>> getAllUsers() {
        return userService.getAllUsers();

    }

    @GetMapping("login")
    public String login(@RequestBody User user) {
        return userService.verify(user);

    }

}
