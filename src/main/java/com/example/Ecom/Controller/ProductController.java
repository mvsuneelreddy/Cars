package com.example.Ecom.Controller;

import com.example.Ecom.Model.Product;
import com.example.Ecom.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("all")
    public ResponseEntity<List<Product>> allproducts(){
        return  new ResponseEntity<>(service.getall(), HttpStatus.FOUND);
    }

    @GetMapping("productn/{Keyword}")
    public ResponseEntity<Product> getproductbyName(@PathVariable String Keyword){
        Product product=service.getByName(Keyword);
        if (product!=null) {
            return new ResponseEntity<>(product, HttpStatus.FOUND);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("product/{id}")
    public ResponseEntity<Product> getproduct(@PathVariable int id){
        Product product= service.getproduct(id);
        if (product!=null) {
            return new ResponseEntity<>(product, HttpStatus.FOUND);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("product")
    public ResponseEntity<Void> addproduct(@RequestBody Product product){
        if (product !=null) {
            service.addOrUpdateproduct(product);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }

    @PutMapping("product/{id}")
    public ResponseEntity<Void> updateproduct(@PathVariable int id ,@RequestBody Product product){
        if (product !=null) {
            service.addOrUpdateproduct(product);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("product/{id}")
    public ResponseEntity<Void> deleteproduct(@PathVariable int id){
        service.delete(id);
            return new ResponseEntity<>(HttpStatus.GONE);

    }


}
