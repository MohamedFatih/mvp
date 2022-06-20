package com.example.springboot.jwt.service;

import com.example.springboot.jwt.entity.Merchant;
import com.example.springboot.jwt.entity.Product;
import com.example.springboot.jwt.entity.User;
import com.example.springboot.jwt.repository.ProductRepository;
import com.example.springboot.jwt.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Collection;

@Service
public class ProductService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository , UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public Collection<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Collection<Product> getProductsByMerchant() {
        String loggedUser = getCurrentUserLogin();
        User user = getUserByUsername(loggedUser);
        return user.getMerchant().getProducts();
    }

    public Product getProductById(long id) {
        return productRepository.getById(id);
    }

    public void addProduct(Product product) {
        String loggedUser = getCurrentUserLogin();
        User user = getUserByUsername(loggedUser);
        Merchant merchant = user.getMerchant();
            product.setMerchant(merchant);
        productRepository.save(product);
    }

    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }

    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username).get();
    }

        public static String getCurrentUserLogin() {
        
            JwtAuthenticationToken authentication = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
            return authentication.getName();
        }

}
