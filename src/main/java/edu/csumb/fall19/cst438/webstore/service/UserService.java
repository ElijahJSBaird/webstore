package edu.csumb.fall19.cst438.webstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.fall19.cst438.webstore.model.User;
import edu.csumb.fall19.cst438.webstore.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    @Autowired
    ProductService productService;

    public boolean signUp(String username, String password) {
        username.toLowerCase();
        if(!userRepo.existsById(username)) {
            userRepo.save(new User(username, password));
            return true;
        }
        return false;
    }

    public boolean authenticate(String username, String password) {
        if(userRepo.existsById(username)) {
            userRepo.findById(username).get().getPassword().equals(password);
            return true;
        }
        return false;
    }

    public boolean addToCart(String username, String productId, Integer quantity) {

        if(quantity < 1) {
            return false;
        }
        if(quantity == 0) {
            return true;
        }
        username.toLowerCase();
        if(userRepo.existsById(username)) {
            User user = userRepo.findById(username).get();
            user.addToCart(productId, quantity);
            userRepo.save(user);
            return true;
        }
        return false;

    }

    public boolean updateToCart(String username, String productId, Integer quantity) {
        username.toLowerCase();
        if(userRepo.existsById(username)) {
            User user = userRepo.findById(username).get();
            user.updateToCart(productId, quantity);
            userRepo.save(user);
            return true;
        }
        return false;
    }

    public boolean checkout(String username) {
        username.toLowerCase();
        if(userRepo.existsById(username)) {
            User user = userRepo.findById(username).get();
            for (String productId : user.getCart().keySet()) {
                productService.updateStock(productId, user.getCart().get(productId));
            }
            user.clearCart();
            userRepo.save(user);
            return true;
        }
        return false;
        

    }

}
