package edu.csumb.fall19.cst438.webstore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.HashMap;

@Document(collection = "User")
public class User {
    @Id
    private String username;
    private String password;
    private HashMap<String, Integer> cart;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.cart = new HashMap<>();
    }

    public void addToCart(String productId, Integer quantity) {
        if(cart.containsKey(productId)) {
            cart.put(productId, cart.get(productId) + quantity);
        } else {
            cart.put(productId, quantity);
        }
    }

    public void updateToCart(String productId, Integer quantity) {

        if(cart.containsKey(productId)) {
            if(quantity == 0) {
                cart.remove(productId);
            } else {
                cart.replace(productId, quantity);
            }
        }
    }

    public void clearCart() {
        cart.clear();
    }

    public HashMap<String, Integer> getCart() {
        return this.cart;
    }

    public void setCart(HashMap<String, Integer> cart) {
        this.cart = cart;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
