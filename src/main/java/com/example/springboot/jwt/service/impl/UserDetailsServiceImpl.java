package com.example.springboot.jwt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;

import com.example.springboot.jwt.entity.User;
import com.example.springboot.jwt.repository.UserRepository;
import com.example.springboot.jwt.service.MyUserDetails;
 
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username).get();
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new MyUserDetails(user);
    }
 
}