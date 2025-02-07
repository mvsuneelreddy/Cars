package com.example.Ecom.Controller;

import com.example.Ecom.Model.Product;
import com.example.Ecom.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("all")
    public List<Product> allproducts(){
        return  service.getall();
    }

    @GetMapping("product/{id}")
    public Product getproduct(@PathVariable int id){
        return service.getproduct(id);
    }

    @PostMapping("product")
    public void addproduct(@RequestBody Product product){
        service.addOrUpdateproduct(product);
    }

    @PutMapping("product/{id}")
    public void updateproduct(@PathVariable int id ,@RequestBody Product product){
        service.addOrUpdateproduct(product);
    }

    @DeleteMapping("product/{id}")
    public void deleteproduct(@PathVariable int id){
        service.delete(id);
    }

}
