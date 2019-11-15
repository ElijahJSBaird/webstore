package edu.csumb.fall19.cst438.webstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import edu.csumb.fall19.cst438.webstore.model.Product;
import edu.csumb.fall19.cst438.webstore.service.ProductService;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/products/add")
    public Product save(@RequestBody Product p) {
        return productService.save(p);
    }

    @GetMapping("/products/getAll")
    public List<Product> getAll() {
        List<Product> result = productService.findAll();
        return result;
    }

    @GetMapping("/products/get/{id}")
    public Optional<Product> getProductById(@PathVariable String id) {
        Optional<Product> result = productService.findById(id);
        return result;
    }


    
}
