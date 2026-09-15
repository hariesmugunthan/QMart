package com.example.QMart.Service;

import com.example.QMart.DTO.CustomerQRResponse;
import com.example.QMart.DTO.InvoiceRequest;
import com.example.QMart.Models.Customer;
import com.example.QMart.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo cr;
    @Autowired
    private QRService qrService;
    @Autowired
    private EmailService emailService;

    public CustomerQRResponse addCustomer(Customer c) throws Exception {

        SecureRandom sr = new SecureRandom();

        int cid;

        do {
            cid = 100000 + sr.nextInt(900000);
        } while (cr.existsById(cid));

        c.setCustomerId(cid);

        cr.save(c);

        String qrCode = qrService.generateQR(cid);

        emailService.sendCustomerQR(
                c.getMail(),
                cid,
                qrCode
        );

        return new CustomerQRResponse(cid, qrCode);
    }
    public boolean customerExists(int id) {
        return cr.existsById(id);
    }
    public void sendInvoice(InvoiceRequest request) throws Exception {

        Customer customer =
                cr.findById(request.getCustomerId()).orElse(null);

        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }

        emailService.sendInvoice(
                customer.getMail(),
                request.getCustomerId(),
                request.getItems()
        );
    }
    public void closeCustomer(int id) {

        if (!cr.existsById(id)) {
            throw new RuntimeException("Customer not found");
        }

        cr.deleteById(id);
    }
}
