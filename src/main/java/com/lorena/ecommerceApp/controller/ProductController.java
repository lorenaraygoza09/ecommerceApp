package com.lorena.ecommerceApp.controller;

import com.lorena.ecommerceApp.model.Product;
import com.lorena.ecommerceApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService service;

    //get all products
    @GetMapping
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    //find products by id
    @GetMapping("/{id}")
    public Product getProductsById(@PathVariable Long id){
    return service.getById(id);
    }
}

