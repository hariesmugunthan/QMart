package com.example.QMart.DTO;

public class LoginRequest {
    private String username;
    private  String password;

    //getters kannu
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    //setters da

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
