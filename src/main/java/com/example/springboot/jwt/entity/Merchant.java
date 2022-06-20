package com.example.springboot.jwt.entity;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "merchants")
public class Merchant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy="merchant")
    private Set<Product> products;

    @OneToOne
    private User user;

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return String return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return Set<Product> return the products
     */
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(Set<Product> products) {
        this.products = products;
    }


    /**
     * @return User return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

}
