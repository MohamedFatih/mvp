package com.example.springboot.jwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.springboot.jwt.entity.User;
 
public interface UserRepository extends JpaRepository<User, Long> {
 
    @Query("SELECT u FROM User u WHERE u.username = :username")
    public Optional<User> getUserByUsername(@Param("username") String username);
    
}