package com.example.QMart.DTO;

public class ManagerDto
{
    private String name;
    private String email;
    private String phone;
    private String password;
    private  String masterpassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMasterPassword() {
        return masterpassword;
    }

    public void setMasterPassword(String masterpass) {
        this.masterpassword = masterpass;
    }


}
