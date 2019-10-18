package edu.csumb.Webstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.csumb.Webstore.model.*;
import edu.csumb.Webstore.repository.ProductRepository;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @PostMapping("/products/add")
    public Product save(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/products/getAll")
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("/products/get/{id}")
    public  Optional<Product> getProductById(@PathVariable String id) {
        return productRepository.findById(id);
    }
}