package com.security.security_jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.web.server.ServerHttpSecurity.HttpsRedirectSpec;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.security_jwt.Repository.UserRepository;
import com.security.security_jwt.model.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public ResponseEntity<String> register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));

        User isUserAlreadyExist = userRepository.findByEmail(user.getEmail());

        if (isUserAlreadyExist == null) {
            try {
                userRepository.save(user);
                return new ResponseEntity<>("Registered Successfully!", HttpStatus.CREATED);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<>("User already existed try with another email", HttpStatus.BAD_REQUEST);

    }

    public String verify(User user) {
        Authentication auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        if (auth != null) {

            return jwtService.generateToken(user.getEmail());

        } else {

            return "failure";

        }
    }

    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }
}
