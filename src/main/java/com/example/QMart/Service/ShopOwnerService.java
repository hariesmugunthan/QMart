package com.example.QMart.Service;

import com.example.QMart.DTO.LoginRequest;
import com.example.QMart.DTO.LoginResponse;
import com.example.QMart.Models.Shop_Owner;
import com.example.QMart.Repository.ShopOwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopOwnerService {
    @Autowired
    private ShopOwnerRepo sor;
    public List<Shop_Owner> getAllShopOwners() {
        return sor.findAll();
    }

    //REGISTER
    public void addShopOwners(Shop_Owner so) {
        sor.save(so);
    }

    //LOGIN

    public LoginResponse shopOwnerLogin(LoginRequest lr) {
        LoginResponse o=new LoginResponse();
        if(sor.existsByEmail(lr.getUsername())){
            if(lr.getPassword().equals(sor.passwordChecker(lr.getUsername()))){
                System.out.println(lr.getPassword()+" "+sor.passwordChecker(lr.getUsername()));
                o.setMessage( "Login successful");
                o.setRole("Shop Owner");
                o.setSuccess(true);
                o.setPk(sor.getIdByEmailAndPassword(lr.getUsername(), lr.getPassword()));
            }
            else{
                o.setMessage( "Wrong Password");
                o.setRole("Shop Owner");
                o.setSuccess(false);
            }

        }
        else {
            o.setMessage( "Invalid UserName");
            o.setRole("Shop Owner");
            o.setSuccess(false);

        }
        return o;
    }

    public Optional<Shop_Owner> getShopOwnerById(int id) {
        return sor.findById(id);
    }
}
