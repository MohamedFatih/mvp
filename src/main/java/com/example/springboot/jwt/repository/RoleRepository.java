package com.example.springboot.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.jwt.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
 
}