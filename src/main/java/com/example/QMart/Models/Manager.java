package com.example.QMart.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int managerId;

    private String name;

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    private String email;

    private String phone;

    private String password;

    //getters

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return this.password;
    }

    //setters

    public void setName(String name) {
        this.name = name;
    }

    public Manager() {
    }

    public Manager(String name, String email, String phone, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public void setPhone(String phone) {
        this.phone = phone;
    }



    public void setPassword(String password) {
        this.password = password;
    }




}
