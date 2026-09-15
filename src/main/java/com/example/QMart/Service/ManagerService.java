package com.example.QMart.Service;

import com.example.QMart.DTO.LoginRequest;
import com.example.QMart.DTO.LoginResponse;
import com.example.QMart.DTO.ManagerDto;
import com.example.QMart.Models.Manager;
import com.example.QMart.Models.Shop_Owner;
import com.example.QMart.Repository.ManagerRepo;
import com.example.QMart.Repository.ShopOwnerRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    @Value("${manager.master-password}")
    private String MasterPass;

    @Autowired
    private ManagerRepo mr;
    @Autowired
    private ShopOwnerRepo sor;


    public String addManager(ManagerDto m) {

        if(m.getMasterPassword().equals(this.MasterPass)){

            Manager manager=new Manager();
            manager.setEmail(m.getEmail());
            manager.setName(m.getName());
            manager.setPassword(m.getPassword());
            manager.setPhone(m.getPhone());
            mr.save(manager);
            return"ok";
        }
        else return"notok";

    }

    public LoginResponse loginManager(LoginRequest lrq) {
        LoginResponse o=new LoginResponse();
        if(mr.existsByEmail(lrq.getUsername())){
            if(lrq.getPassword().equals(mr.passwordChecker(lrq.getUsername()))){
                o.setMessage( "Login successful");
                o.setRole("Manager");
                o.setSuccess(true);
                o.setPk(mr.getIdByEmailAndPassword(lrq.getUsername(), lrq.getPassword()));
            }
            else{
                o.setMessage( "Wrong Password");
                o.setRole("Manager");
                o.setSuccess(false);
            }

        }
        else {
            o.setMessage( "Invalid UserName");
            o.setRole("Manager");
            o.setSuccess(false);

        }
        return o;
    }
    public List<Manager> ManagerService() {
        return mr.findAll();
    }
    public List<Shop_Owner> displayPendingShopOwners() {
        return sor.displayPendingShopOwners();
    }

    @Transactional
    public void changeStatus(int id) {
        if(sor.findByStatus(id).equals("PENDING")) sor.changeStatustoApproved(id);
        else sor.changeStatustoPending(id);
    }

    public Optional<Manager> getManagerById(int id) {
        return mr.findById(id);
    }
}
