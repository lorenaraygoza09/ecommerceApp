package com.lorena.ecommerceApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RoleController {

    @GetMapping("/user/test")
    public String userTest(){
        return "Only users";
    }

    @GetMapping("/admin/test")
    public String adminTest(){
        return "Only admin";
    }
}
