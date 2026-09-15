package com.example.QMart.Repository;

import com.example.QMart.Models.Shop_Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface ShopOwnerRepo extends JpaRepository<Shop_Owner,Integer> {
    @Query("SELECT COUNT(s) > 0 FROM Shop_Owner s WHERE s.email = :email")
    public boolean existsByEmail(@Param("email") String email);

    @Query(nativeQuery = true, value = "select password from Shop_Owner where email=?1")
    public String passwordChecker(String m);

    @Query(nativeQuery = true,value = "SELECT * from Shop_Owner where status ='PENDING'")
    public List<Shop_Owner> displayPendingShopOwners();

    @Modifying
    @Query(nativeQuery = true,value = "update Shop_Owner set status='APPROVED'where owner_id=:id")
    public void changeStatustoApproved(@RequestParam("id") int id);
    @Modifying
    @Query(nativeQuery = true,value = "update Shop_Owner set status='PENDING'where owner_id=:id")
    public void changeStatustoPending(@RequestParam("id") int id);
    @Query(nativeQuery = true,value = "select status from Shop_Owner where owner_id=:id")
    public String findByStatus(@RequestParam("id") int id);
    @Query(nativeQuery = true,value = "select  owner_id from Shop_Owner where email=?1 And password=?2")
    public int getIdByEmailAndPassword(String email,String password);

}
