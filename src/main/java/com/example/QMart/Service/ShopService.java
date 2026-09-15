package com.example.QMart.Service;

import com.example.QMart.Models.Shop;
import com.example.QMart.Models.Shop_Owner;
import com.example.QMart.Repository.ShopRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    @Autowired
    private ShopRepo sr;

    public String addShop(Shop s) {
        if(sr.existsById(s.getOwner_id())){
            return "shop exists";
        }
        else{
            s.setTotalTransaction(0.0);
            sr.save(s);
            return "added";
        }
    }


    @Transactional
    public void resetAllTransactions() {
        sr.resetAllTransactions();
    }
    public List<Shop> getAllShops() {
        return sr.getAllShops();
    }
    public boolean shopStatus(int ownerId) {
        return sr.shopExists(ownerId);
    }
    public Shop getShopByOwnerId(int ownerId) {
        return sr.getShopByOwnerId(ownerId);
    }
}
