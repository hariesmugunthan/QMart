package com.example.QMart.Repository;

import com.example.QMart.Models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepo extends JpaRepository<Manager,Integer> {
    public boolean existsByEmail(String mail);

    @Query(nativeQuery = true,value = "select password from Manager where email=?1")
    public String passwordChecker(String m);

    @Query(nativeQuery = true,value = "select manager_id from Manager where email=?1 And password=?2")
    public int getIdByEmailAndPassword(String email,String password);



}
