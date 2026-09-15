package com.example.QMart.Controller;

import com.example.QMart.DTO.CustomerQRResponse;
import com.example.QMart.DTO.InvoiceRequest;
import com.example.QMart.Models.Customer;
import com.example.QMart.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CustomerController {

    @Autowired
    private CustomerService cs;
    @PostMapping("/createnewcustomer")
    public CustomerQRResponse addCustomer(@RequestBody Customer c) throws Exception {
        return cs.addCustomer(c);
    }
    @GetMapping("/customerexists/{id}")
    public boolean customerExists(@PathVariable int id) {
        return cs.customerExists(id);
    }
    @PostMapping("/sendinvoice")
    public String sendInvoice(@RequestBody InvoiceRequest request) throws Exception {

        cs.sendInvoice(request);

        return "Invoice sent successfully";
    }
    @DeleteMapping("/closecustomer/{id}")
    public String closeCustomer(@PathVariable int id) {

        cs.closeCustomer(id);

        return "Customer closed";
    }
}
