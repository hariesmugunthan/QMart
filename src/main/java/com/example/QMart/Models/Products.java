package com.example.QMart.Models;

import jakarta.persistence.*;

@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;

    private String name;
    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Shop_Owner owner;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Shop_Owner getOwner() {
        return owner;
    }

    public void setOwner(Shop_Owner owner) {
        this.owner = owner;
    }


}
