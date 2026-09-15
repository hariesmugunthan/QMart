package com.example.QMart.DTO;

import com.example.QMart.Models.PurchasedItems;

import java.util.List;

public class ShopInvoiceDTO {

    private int shopId;
    private List<PurchasedItems> items;

    public ShopInvoiceDTO(int shopId, List<PurchasedItems> items) {
        this.shopId = shopId;
        this.items = items;
    }

    public int getShopId() {
        return shopId;
    }

    public List<PurchasedItems> getItems() {
        return items;
    }
}