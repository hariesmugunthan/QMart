package com.example.QMart.Controller;

import com.example.QMart.DTO.LoginRequest;
import com.example.QMart.DTO.LoginResponse;
import com.example.QMart.Models.Shop_Owner;
import com.example.QMart.Service.ShopOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ShopOwnerController {
    @Autowired
    private ShopOwnerService sos;

     //getrequest

     @GetMapping("/shopowners")
     public ResponseEntity<?> getAllShopOwners() {

         List<Shop_Owner> owners = sos.getAllShopOwners();

         if (owners.isEmpty()) {
             return ResponseEntity.ok("No shop owners found");
         }

         return ResponseEntity.ok(owners);
     }
    @GetMapping("/getshopowner/{id}")
    public Optional<Shop_Owner> getShopOwnerById(@PathVariable int id){
         return sos.getShopOwnerById(id);
    }

    //REGISTER

    @PostMapping("/addshopowners")
    public String addShopOwner(@RequestBody Shop_Owner so){
        sos.addShopOwners(so);
         return "added";
    }

    //Login
    @PostMapping("/shopownerlogin")
    public LoginResponse shopOwnerLogin(@RequestBody LoginRequest lr){
         return sos.shopOwnerLogin(lr);
    }
}
