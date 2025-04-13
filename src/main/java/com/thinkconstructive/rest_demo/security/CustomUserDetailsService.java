package com.thinkconstructive.rest_demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Misalnya Anda mengambil data dari database atau sistem lain
        if ("user".equals(username)) {  // Contoh data pengguna
            return new CustomUserDetails(username, "password", new ArrayList<>());  // Berikan roles atau authorities sesuai kebutuhan
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
