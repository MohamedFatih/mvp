package com.example.springboot.jwt.controller;

import com.example.springboot.jwt.entity.Product;
import com.example.springboot.jwt.service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('MERCHANT')")
    public Collection<Product> getProducts() {
        return productService.getProductsByMerchant();
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('MERCHANT', 'ADMIN')")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void removeProduct(@PathVariable long id) {
        productService.deleteProductById(id);
    }

}
