package com.example.QMart.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Shop_Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int owner_id;
    private String name;
    private String phone;
    private String email;

    private String password;
    private String status ="PENDING";
    private LocalDateTime created_at;
    @PrePersist
    public void onCreate() {
        created_at = LocalDateTime.now();
    }

    //getters

    public int getOwner_id() {
        return owner_id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }
    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }
}
