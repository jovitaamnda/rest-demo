package com.thinkconstructive.rest_demo.controller;

import com.thinkconstructive.rest_demo.model.User;
import com.thinkconstructive.rest_demo.dto.AuthRequest;
import com.thinkconstructive.rest_demo.repository.UserRepository;
import com.thinkconstructive.rest_demo.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Register endpoint (POST /auth/register)
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest request) {
        // Cek apakah username sudah ada
        if (userRepository.findByUsername(request.getUsername()) != null) {
            return ResponseEntity.status(400).body("Username already taken");
        }

        // Simpan pengguna baru
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));  // Enkripsi password
        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully");
    }

    // Login endpoint (POST /auth/login)
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {
        // Log untuk memverifikasi data
        System.out.println("Login attempt with username: " + request.getUsername());
    
        User user = userRepository.findByUsername(request.getUsername());
    
        if (user != null && passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            String token = jwtUtil.generateToken(user.getUsername());
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
    
}
