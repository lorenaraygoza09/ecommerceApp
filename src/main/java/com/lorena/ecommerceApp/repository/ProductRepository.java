package com.lorena.ecommerceApp.repository;

import com.lorena.ecommerceApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //find product by id
    Optional<Product> findById(Long id);
}
