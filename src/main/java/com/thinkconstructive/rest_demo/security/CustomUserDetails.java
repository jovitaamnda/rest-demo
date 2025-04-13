package com.thinkconstructive.rest_demo.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities; // Tetap final

    // Konstruktor untuk CustomUserDetails
    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities; // Nilai hanya diberikan di sini
    }

    // Implementasi untuk getAuthorities() dari UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    // Implementasi untuk getUsername() dari UserDetails
    @Override
    public String getUsername() {
        return username;
    }

    // Implementasi untuk getPassword() dari UserDetails
    @Override
    public String getPassword() {
        return password;
    }

    // Implementasi untuk isAccountNonExpired() dari UserDetails
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // Implementasi untuk isAccountNonLocked() dari UserDetails
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // Implementasi untuk isCredentialsNonExpired() dari UserDetails
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // Implementasi untuk isEnabled() dari UserDetails
    @Override
    public boolean isEnabled() {
        return true;
    }
}
