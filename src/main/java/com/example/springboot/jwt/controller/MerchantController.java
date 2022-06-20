package com.example.springboot.jwt.controller;

import java.util.Collection;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.jwt.entity.Merchant;
import com.example.springboot.jwt.repository.MerchantRepository;

@RestController
@RequestMapping("merchants")
public class MerchantController {
    
    private final MerchantRepository merchantRepository;

    public MerchantController(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    // @PostMapping
    // @PreAuthorize("hasAuthority('ADMIN')")
    // public Collection<Merchant> createMerchants() {
    //     return merchantRepository.findAll();
    // }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Collection<Merchant> getMerchants() {
        return merchantRepository.findAll();
    }
    
}
