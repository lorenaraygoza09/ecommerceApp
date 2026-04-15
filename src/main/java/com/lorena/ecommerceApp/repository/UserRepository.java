package com.lorena.ecommerceApp.repository;

import com.lorena.ecommerceApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {
    //find user by email
    Optional<User> findByEmail(String email);
    //find user by id
    Optional<User> findById(Long id);
}
