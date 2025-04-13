package com.thinkconstructive.rest_demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "Jovitacans123Jovitacans123Jovitacans123";  // Gunakan secret key yang kuat

    // Generate token JWT
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)  // Menyimpan username dalam subject
                .setIssuedAt(new Date())  // Set waktu pembuatan token
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))  // Token expired setelah 10 jam
                .signWith(getSigningKey(), SignatureAlgorithm.HS512)  // Menandatangani token dengan secret key
                .compact();
    }

    private Key getSigningKey() {
        throw new UnsupportedOperationException("Unimplemented method 'getSigningKey'");
    }

    // Mengekstrak username dari token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);  // Mengambil username dari token
    }

    // Mengekstrak claim dari token
    public <T> T extractClaim(String token, ClaimsResolver<T> claimsResolver) {
        final Claims claims = extractAllClaims(token);  // Mengambil semua claims dari token
        return claimsResolver.resolve(claims);  // Mengembalikan klaim sesuai request
    }

    // Mengekstrak semua klaim dari token
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)  // Memverifikasi token dengan secret key
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Validasi token
    public boolean validateToken(String token) {
        try {
            extractAllClaims(token);  // Jika tidak ada error saat mengekstrak klaim, token valid
            return true;
        } catch (Exception e) {
            return false;  // Token tidak valid
        }
    }

    @FunctionalInterface
    public interface ClaimsResolver<T> {
        T resolve(Claims claims);
    }
}
