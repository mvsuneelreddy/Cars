package com.example.Ecom.Service;

import com.example.Ecom.Model.Product;
import com.example.Ecom.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getall() {
        return repo.findAll();
    }

    public Product getproduct(int id) {
        return repo.findById(id).orElse(new Product());
    }

    public void addOrUpdateproduct(Product product) {
        repo.save(product);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public Product getByName(String Keyword) {
        return repo.findByNameContaining(Keyword);
    }
}
