package com.example.springboot.jwt.entity;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
 
@Entity
@Table(name = "users")
public class User {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    @NotBlank
    private String username;
    private String password;
    private boolean enabled;
    private boolean tokenExpired;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
            )
    private Set<Role> roles = new HashSet<>(); 

    @OneToOne
    private Merchant merchant ;
    

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
     * @return String return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**getMerchant()
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return boolean return the enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return boolean return the tokenExpired
     */
    public boolean isTokenExpired() {
        return tokenExpired;
    }

    /**
     * @param tokenExpired the tokenExpired to set
     */
    public void setTokenExpired(boolean tokenExpired) {
        this.tokenExpired = tokenExpired;
    }

    /**
     * @return Set<Role> return the roles
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    /**
     * @return Merchant return the merchant
     */
    public Merchant getMerchant() {
        return merchant;
    }

    /**
     * @param merchant the merchant to set
     */
    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

}