package edu.csumb.fall19.cst438.webstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.fall19.cst438.webstore.model.Product;
import edu.csumb.fall19.cst438.webstore.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepo;

    public Product save(Product p) {
        return productRepo.save(p);
    }

    public Optional<Product> findById(String id) {
        return productRepo.findById(id);
    }

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public boolean updateStock(String productId, Integer quantity) {
       if(productRepo.existsById(productId)) {
            Product product = productRepo.findById(productId).get();
            product.updateStock(quantity);
            productRepo.save(product);
            return true;
       } else {
           return false;
       }

    }
}