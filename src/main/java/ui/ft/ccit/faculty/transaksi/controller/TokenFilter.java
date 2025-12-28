package ui.ft.ccit.faculty.transaksi.controller;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ui.ft.ccit.faculty.transaksi.service.AuthService;

import java.io.IOException;
import java.util.Collections;

@Component
public class TokenFilter extends OncePerRequestFilter {

    @Autowired
    private AuthService authService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 1. Ambil Header bernama "Authorization"
        String authHeader = request.getHeader("Authorization");

        // 2. Cek apakah formatnya "Bearer <token>"
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7); // Ambil kode setelah kata "Bearer "

            // 3. Cek ke AuthService apakah token valid
            if (authService.validateToken(token)) {
                // Jika valid, izinkan masuk sebagai "User"
                UsernamePasswordAuthenticationToken authentication = 
                        new UsernamePasswordAuthenticationToken("User", null, Collections.emptyList());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        // 4. Lanjut ke proses berikutnya
        filterChain.doFilter(request, response);
    }
}