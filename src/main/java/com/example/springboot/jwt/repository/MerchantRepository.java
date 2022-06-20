package com.example.springboot.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.jwt.entity.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, Long>{
    
}
