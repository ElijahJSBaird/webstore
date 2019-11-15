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
import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "Adding new user.")
    @PostMapping("/auth/add")
    public boolean signUp(@RequestParam("username") String username,  @RequestParam("password") String password) {
        return userService.signUp(username, password);
    }

    @ApiOperation(value = "Checking username and password is matched.")
    @PostMapping("/auth")
    public boolean authenticate(@RequestParam("username") String username,  @RequestParam("password") String password) {
        return userService.authenticate(username, password);
    }

    
    
}