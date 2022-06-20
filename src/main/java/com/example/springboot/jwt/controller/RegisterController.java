package com.example.springboot.jwt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.jwt.Exceptions.UserAlreadyExistAuthenticationException;
import com.example.springboot.jwt.entity.NewUser;
import com.example.springboot.jwt.repository.UserRepository;
// import com.example.springboot.jwt.service.impl.UserDetailsServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
public class RegisterController {

    private final UserRepository userRepository;
    // private final UserDetailsServiceImpl userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public RegisterController (UserRepository userRepository  , PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        // this.userDetailsService = userDetailsService ;
    }
    @PostMapping(path = "register") 
    @ResponseStatus(HttpStatus.CREATED)
    public void register (@RequestBody NewUser newUser) {
        userRepository.getUserByUsername(newUser.getUsername().toLowerCase()).ifPresent(u -> {throw new UserAlreadyExistAuthenticationException("User Already Exist");});
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userRepository.save(newUser);
    }
}
