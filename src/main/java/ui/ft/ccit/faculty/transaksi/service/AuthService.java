package ui.ft.ccit.faculty.transaksi.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AuthService {

    private static final Map<String, String> tokenStore = new HashMap<>();

    public String login(String username, String password) {
        
        if ("admin".equals(username) && "password123".equals(password)) {
            // Generate Token Unik (seperti karcis parkir)
            String token = UUID.randomUUID().toString();
            tokenStore.put(token, username);
            return token;
        }
        return null; // Login gagal
    }

    public boolean validateToken(String token) {
        // Cek apakah token ada di catatan kita
        return tokenStore.containsKey(token);
    }
}