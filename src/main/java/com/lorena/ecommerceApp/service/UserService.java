package com.lorena.ecommerceApp.service;

import com.lorena.ecommerceApp.jwt.AuthResponse;
import com.lorena.ecommerceApp.jwt.JwtService;
import com.lorena.ecommerceApp.model.Role;
import com.lorena.ecommerceApp.model.User;
import com.lorena.ecommerceApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User registerUser(User user) {
        //validate existence of the email
        if (repository.findByEmail(user.getEmail()).isPresent()){
            throw new RuntimeException("This email already exist");
        }
        //user by default
        user.setRole(Role.USER);
        //save it in db
        return repository.save(user);
    }

    @Autowired
    private JwtService jwtService;
    public AuthResponse loginUser(User user){
        User existingUser = repository.findByEmail(user.getEmail())
                .orElseThrow(() -> new RuntimeException("This email doesn't exist"));
        if (!existingUser.getPassword().equals(user.getPassword())){
            throw new RuntimeException("Invalid password");
        }
        String token = jwtService.generateToken(existingUser.getEmail(),
                existingUser.getRole().name());
        return new AuthResponse(token);
    }

}



