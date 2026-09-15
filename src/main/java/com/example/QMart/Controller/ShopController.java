package com.example.QMart.Controller;

import com.example.QMart.Models.Shop;
import com.example.QMart.Service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ShopController {
    @Autowired
   private ShopService ss;
    @PostMapping("/createshop")
    public String addShop(@RequestBody Shop s){
        return ss.addShop(s);
    }
    @GetMapping("/shopstatus/{ownerId}")
    public boolean shopStatus(@PathVariable int ownerId) {
        return ss.shopStatus(ownerId);
    }
    @GetMapping("/getshopbyowner/{ownerId}")
    public Shop getShopByOwnerId(@PathVariable int ownerId) {
        return ss.getShopByOwnerId(ownerId);
    }
    @GetMapping("/shopstatistics")
    public List<Shop> getShopStatistics() {
        return ss.getAllShops();
    }
}
