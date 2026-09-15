package com.example.QMart.Controller;

import com.example.QMart.Models.Products;
import com.example.QMart.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProductController {
    @Autowired
    private ProductService ps;

    //adding products
    @PostMapping("/addproduct")
    public String addProduct(@RequestBody Products p){
        ps.addProduct(p);
        return "added";

    }
    @PostMapping("/addproducts")
    public String addProducts(@RequestBody List<Products> p){
        return ps.addProducts(p);

    }
    //reducequantity
    @PostMapping("/reducequantity")
    public void reduceQuantity(@RequestParam("product_id") int id, @RequestParam("value") int v){
         ps.reduceQuantity(id,v);

    }
    //updatequantity
    @PostMapping("/updatequantity")
    public void updateQuantity(@RequestParam("product_id") int id, @RequestParam("value") int v){
        ps.updateQuantity(id,v);

    }

    //getproducts
    @GetMapping("/getproducts/{id}")
    public List<Products> getProductsByShopOwnerId(@PathVariable int id){
        return ps.getProductsByShopOwnerId(id);
    }
    @PostMapping("/updateprice")
    public void updatePrice(@RequestParam("id")int id,@RequestParam("price") double p){
        ps.updatePrice(id,p);
    }
    @GetMapping("/deleteproduct/{id}")
    public void deleteProduct(@PathVariable int id){
        ps.deleteproduct(id);

    }

}
