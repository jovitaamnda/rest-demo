package com.thinkconstructive.rest_demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.lang.NonNull;



import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.ServletException;


@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;  // Pastikan class JwtUtil ada

    @Autowired
    private CustomUserDetailsService userDetailsService;  // Pastikan class CustomUserDetails ada


    @Override
protected void doFilterInternal(@NonNull HttpServletRequest request,
                                @NonNull HttpServletResponse response,
                                @NonNull FilterChain filterChain)
        throws ServletException, IOException {

    String path = request.getRequestURI();
    String token = request.getHeader("Authorization");

    // Endpoint publik: skip validasi token meskipun ada header Authorization
    if (path.equals("/auth/register") || path.equals("/auth/login")) {
        filterChain.doFilter(request, response);
        return;
    }

    // Kalau token ada dan diawali Bearer, lakukan validasi
    if (token != null && token.startsWith("Bearer ")) {
        token = token.substring(7); // hapus "Bearer "
        boolean isValid = jwtUtil.validateToken(token);

        if (isValid) {
            String username = jwtUtil.extractUsername(token);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
    }

    filterChain.doFilter(request, response);
}
}