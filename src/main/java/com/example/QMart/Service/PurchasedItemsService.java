package com.example.QMart.Service;

import com.example.QMart.DTO.ShopInvoiceDTO;
import com.example.QMart.Models.Customer;
import com.example.QMart.Models.Products;
import com.example.QMart.Models.PurchasedItems;
import com.example.QMart.Repository.CustomerRepo;
import com.example.QMart.Repository.ProductsRepo;
import com.example.QMart.Repository.PurchasedItemsRepo;
import com.example.QMart.Repository.ShopRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.QMart.Repository.CustomerRepo;
import com.example.QMart.Service.EmailService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PurchasedItemsService {
    @Autowired
    private PurchasedItemsRepo pir;
    @Autowired
    private ShopRepo sr;
    @Autowired
    private ProductsRepo pr;
    @Autowired
    private CustomerRepo cr;

    @Autowired
    private EmailService emailService;

    @Transactional
    public void addpurchasedItems(List<PurchasedItems> pi) {

        double total = 0;

        for (PurchasedItems item : pi) {

            System.out.println(
                    "PRODUCT ID RECEIVED = "
                            + item.getProduct().getProduct_id()
            );

            Products product = pr.findById(
                    item.getProduct().getProduct_id()
            ).orElseThrow();

            item.setProduct(product);

            pir.save(item);

            total = total + item.getSubtotal();
        }

        int sid = pi.get(0).getShop().getSid();

        double v = sr.getTotalTransaction(sid);

        v = v + total;

        sr.setTotalTransaction(v, sid);
    }
    public List<ShopInvoiceDTO> getAllInvoices(int cid) {

        List<PurchasedItems> items =
                pir.getPurchasedItemsByCustomer(cid);

        Map<Integer, List<PurchasedItems>> grouped =
                items.stream()
                        .collect(Collectors.groupingBy(
                                item -> item.getShop().getSid()
                        ));

        List<ShopInvoiceDTO> result = new ArrayList<>();

        for (Map.Entry<Integer, List<PurchasedItems>> entry
                : grouped.entrySet()) {

            result.add(
                    new ShopInvoiceDTO(
                            entry.getKey(),
                            entry.getValue()
                    )
            );
        }

        return result;
    }
    public void sendAllInvoice(int cid) throws Exception {

        Customer customer =
                cr.findById(cid).orElse(null);

        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }

        List<PurchasedItems> items =
                pir.getPurchasedItemsByCustomer(cid);

        if (items.isEmpty()) {
            throw new RuntimeException("No purchased items found");
        }

        Map<Integer, List<PurchasedItems>> grouped =
                items.stream()
                        .collect(Collectors.groupingBy(
                                item -> item.getShop().getSid()
                        ));

        emailService.sendAllInvoice(
                customer.getMail(),
                cid,
                grouped
        );
    }
}
