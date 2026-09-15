package com.example.QMart.Repository;

import com.example.QMart.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {


    public boolean existsById(int id);
}
