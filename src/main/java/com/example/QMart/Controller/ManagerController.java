package com.example.QMart.Controller;

import com.example.QMart.DTO.LoginRequest;
import com.example.QMart.DTO.LoginResponse;
import com.example.QMart.DTO.ManagerDto;
import com.example.QMart.Models.Manager;
import com.example.QMart.Models.Shop_Owner;
import com.example.QMart.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ManagerController {
    @Autowired
    private ManagerService ms;


    //display all dokku bois
    @GetMapping("/managers")
    public List<Manager> getAllManagers(){
        return ms.ManagerService();
    }
    
    //returning specific manager by id
    @GetMapping("/getmanager/{id}")
    public Optional<Manager> getManagerById(@PathVariable int id){
        return ms.getManagerById(id);
    }

    @GetMapping("/pendingshopowmers")
    public List<Shop_Owner> displayPendingShopOwners(){
        return ms.displayPendingShopOwners();
    }

    // REGISTER

    @PostMapping("/addmanager")
    public String addManager(@RequestBody ManagerDto m){
       String s= ms.addManager(m);
        if(s.equals("ok")) return "added";
        else return "password thappu da baadu";
    }

    //LOGIN
    @PostMapping("/managerlogin")
    public LoginResponse loginManager(@RequestBody LoginRequest lrq){
        return ms.loginManager(lrq);
    }

    //change the status
    @PostMapping("/changestatus")
    public void changeStatus(@RequestParam("id")int id){
         ms.changeStatus(id);
    }


}
