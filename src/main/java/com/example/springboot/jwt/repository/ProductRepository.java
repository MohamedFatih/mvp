package com.example.springboot.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.jwt.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
