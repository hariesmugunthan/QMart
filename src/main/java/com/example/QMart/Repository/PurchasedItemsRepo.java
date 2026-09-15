package com.example.QMart.Repository;

import com.example.QMart.Models.PurchasedItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchasedItemsRepo extends JpaRepository<PurchasedItems,Integer> {
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM purchased_items WHERE c_id=?1 ORDER BY sid"
    )
    public List<PurchasedItems> getPurchasedItemsByCustomer(int cid);
}
