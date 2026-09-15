package com.example.QMart.Service;

import com.example.QMart.Models.Products;
import com.example.QMart.Repository.ProductsRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductsRepo pr;

    public void addProduct(Products p) {
        pr.save(p);
    }

    public String addProducts(List<Products> p) {
        pr.saveAll(p);
        return"added";
    }

    public List<Products> getProductsByShopOwnerId(int id) {
        return pr.getProductsByShopOwnerId(id);
    }
    @Transactional
    public void reduceQuantity(int id, int v) {
        int value=pr.getQuantity(id);
        if(value>=v){
            pr.modifyQuantity(value-v,id);
        }

    }
    @Transactional

    public void updateQuantity(int id, int v) {
        int value=pr.getQuantity(id);
        pr.modifyQuantity(value+v,id);
    }
    @Transactional
    public void updatePrice(int id, double p) {
        pr.updatePrice(p,id);

    }

    public void deleteproduct(int id) {
        pr.deleteById(id);
    }
}
