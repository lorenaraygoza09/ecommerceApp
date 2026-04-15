package com.lorena.ecommerceApp.controller;

import com.lorena.ecommerceApp.jwt.AuthResponse;
import com.lorena.ecommerceApp.model.User;
import com.lorena.ecommerceApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    private UserService service;

    //create user
    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public User register(@RequestBody User user) {
        return service.registerUser(user);
    }

    //login
    @PostMapping("login")
    public AuthResponse login(@RequestBody User user){
        return service.loginUser(user);
    }

    //GET DE PRUEBA
    @GetMapping("/user")
    public String user(){
        return "Solo User";
    }

   /* @GetMapping("/admin")
    public String admin(){
        return "Solo admin";
    }
    */
}



