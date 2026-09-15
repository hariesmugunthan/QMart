package com.example.QMart.Models;

import jakarta.persistence.*;

@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;

    @ManyToOne
    @JoinColumn(name = "shop_owner_id")
    private Shop_Owner owner_id;

    private double totalTransaction;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getOwner_id() {
        return owner_id.getOwner_id();
    }

    public void setOwner_id(Shop_Owner owner_id) {
        this.owner_id = owner_id;
    }

    public double getTotalTransaction() {
        return totalTransaction;
    }

    public void setTotalTransaction(double totalTransaction) {
        this.totalTransaction = totalTransaction;
    }
}
