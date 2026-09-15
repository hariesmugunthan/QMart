package com.example.QMart.Models;

import jakarta.persistence.*;

@Entity
public class PurchasedItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pi_id;

    @ManyToOne
    @JoinColumn(
            name = "c_id",
            nullable = true,
            foreignKey = @ForeignKey(
                    foreignKeyDefinition =
                            "FOREIGN KEY (c_id) REFERENCES customer(cid) ON DELETE SET NULL"
            )
    )
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "sid")
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;

    private int quantity;

    private double price;

    private double subtotal;


    public int getPi_id() {
        return pi_id;
    }

    public void setPi_id(int pi_id) {
        this.pi_id = pi_id;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }


    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
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


    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}