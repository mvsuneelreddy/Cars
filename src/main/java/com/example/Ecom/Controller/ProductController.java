package com.example.Ecom.Controller;

import com.example.Ecom.Model.Product;
import com.example.Ecom.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
