package com.example.springboot.jwt.entity;

import javax.persistence.*;
 
@Entity
@Table(name = "roles")
public class Role {
    

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    private String name;
    public Integer getId() {
        return id;
    }


    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
