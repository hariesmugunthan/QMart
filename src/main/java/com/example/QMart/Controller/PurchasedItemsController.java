package com.example.QMart.Controller;

import com.example.QMart.DTO.ShopInvoiceDTO;
import com.example.QMart.Models.PurchasedItems;
import com.example.QMart.Service.PurchasedItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class PurchasedItemsController {
    @Autowired
    private PurchasedItemsService pis;
    @GetMapping("/getallinvoice/{cid}")
    public List<ShopInvoiceDTO> getAllInvoices(
            @PathVariable int cid) {

        return pis.getAllInvoices(cid);
    }
    @PostMapping("/sendallinvoice/{cid}")
    public String sendAllInvoice(@PathVariable int cid) throws Exception {

        pis.sendAllInvoice(cid);

        return "All invoice sent successfully";
    }
    @PostMapping("/addpruchaseditems")
    public void addpurchasedItems(@RequestBody List<PurchasedItems> pi){
        pis.addpurchasedItems(pi);
    }
}
