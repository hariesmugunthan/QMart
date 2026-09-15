package com.example.QMart.Repository;

import com.example.QMart.Models.Shop;
import com.example.QMart.Models.Shop_Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepo extends JpaRepository<Shop,Integer> {

    @Query("SELECT COUNT(s) > 0 FROM Shop s WHERE s.owner_id.owner_id = :ownerId")
    boolean shopExists(@Param("ownerId") int ownerId);

    @Query("SELECT s.totalTransaction FROM Shop s WHERE s.sid = ?1")
    public double getTotalTransaction(int sid);

    @Modifying
    @Query("UPDATE Shop s SET s.totalTransaction = ?1 WHERE s.sid = ?2")
    public void setTotalTransaction(double d, int sid);

    @Query("SELECT s FROM Shop s WHERE s.owner_id.owner_id = ?1")
    public Shop getShopByOwnerId(int ownerId);
    @Modifying

    @Query("UPDATE Shop s SET s.totalTransaction = 0.0")
    public void resetAllTransactions();
    @Query("SELECT s FROM Shop s")
    public List<Shop> getAllShops();
}