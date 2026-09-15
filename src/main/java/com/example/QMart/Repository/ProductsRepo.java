package com.example.QMart.Repository;

import com.example.QMart.Models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductsRepo extends JpaRepository<Products,Integer> {
    @Query(nativeQuery = true,value = "select * from products where owner_id=?1")
    public List<Products> getProductsByShopOwnerId(int id);

    @Modifying
    @Query(nativeQuery = true,value = "update products set quantity=?1 where product_id=?2")
    public void modifyQuantity(int qty,int product_id);



    @Query(nativeQuery = true,value = "select quantity from products where product_id=?1")
    public int getQuantity(int id);

    @Modifying
    @Query(nativeQuery = true,value = "update products set price=?1 where product_id=?2")
    public void updatePrice(double price,int id);



}
