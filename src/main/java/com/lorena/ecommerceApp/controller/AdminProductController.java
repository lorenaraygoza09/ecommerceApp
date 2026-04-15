package com.lorena.ecommerceApp.controller;

import com.lorena.ecommerceApp.model.Product;
import com.lorena.ecommerceApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/products")
public class AdminProductController {

    @Autowired
    private ProductService service;
    //create product
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product){
        return service.createProduct(product);
    }
    //update products
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        System.out.println(product.getName());
        return service.updateProduct(id, product);
    }
    //delete product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
         service.deleteProduct(id);
         return "Product deleted successfully";
    }
}
