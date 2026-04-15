package com.lorena.ecommerceApp.service;

import com.lorena.ecommerceApp.model.Product;
import com.lorena.ecommerceApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product createProduct(Product product){
        return repository.save(product);
    }

    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    public Product getById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product updateProduct(Long id, Product updateProduct){
        System.out.println("Updating product...");
        Product existingProduct = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        System.out.println(existingProduct.getName());

        existingProduct.setName(updateProduct.getName());
        existingProduct.setDescription(updateProduct.getDescription());
        existingProduct.setPrice(updateProduct.getPrice());
        existingProduct.setStock(updateProduct.getStock());

        System.out.println(existingProduct.getName());
        return repository.save(existingProduct);
    }

    public void deleteProduct(Long id){
        Product product = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found"));

        repository.delete(product);
    }
}
