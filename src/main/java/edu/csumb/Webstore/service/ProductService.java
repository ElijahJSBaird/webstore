package edu.csumb.Webstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.Webstore.model.Product;
import edu.csumb.Webstore.repository.ProductRepository;

@Service
public class ProductService{
    @Autowired
    ProductRepository ProductRepo;

    public Product save(Product p) {
        return ProductRepo.save(p);
    }

    public Optional<Product> findById(String id) {
        return ProductRepo.findById(id);
    }

    public List<Product> findAll() {
        return ProductRepo.findAll();
    }
}