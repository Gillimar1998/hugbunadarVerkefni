package com.example.hugbunadarVerkefni.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    // Default constructor required by JPA
    public User() {}

    // Constructor with parameters
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;  // Make sure this is hashed before storing
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;  // Make sure to hash before setting
    }


    public Long getId() {
        return id;
    }

    // þarf setId?
/*
    public void setId(Long id) {
        this.id = id;
    }

 */
}
