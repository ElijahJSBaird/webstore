package edu.csumb.fall19.cst438.webstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import edu.csumb.fall19.cst438.webstore.model.User;
import edu.csumb.fall19.cst438.webstore.service.UserService;
import edu.csumb.fall19.cst438.webstore.service.ProductService;

import io.swagger.annotations.ApiOperation;

@RestController
public class CartController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "Adding new product to user cart.")
    @PostMapping("/cart/add")
    public boolean addToCart(@RequestParam("username") String username,  @RequestParam("productId") String productId, @RequestParam("quantity") Integer quantity) {
        return userService.addToCart(username, productId, quantity);
    }

    @ApiOperation(value = "Updating exist cart.")
    @PostMapping("/cart/update")
    public boolean updateToCart(@RequestParam("username") String username,  @RequestParam("productId") String productId, @RequestParam("quantity") Integer quantity) {
        return userService.updateToCart(username, productId, quantity);
    }

    @ApiOperation(value = "Allows users to checkout their cart.")
    @PostMapping("/cart/checkout")
    public boolean checkOut(@RequestParam("username") String username) {
        return userService.checkout(username);
    }
}