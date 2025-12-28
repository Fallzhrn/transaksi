package ui.ft.ccit.faculty.transaksi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ui.ft.ccit.faculty.transaksi.controller.TokenFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private TokenFilter tokenFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Matikan CSRF untuk memudahkan Postman
            .authorizeHttpRequests(auth -> auth
                // Izinkan siapapun mengakses Login & GET (lihat data)
                .requestMatchers("/api/auth/login").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
                
                // SISANYA (POST, PUT, DELETE) WAJIB PUNYA TOKEN
                .anyRequest().authenticated()
            )
            // Pasang Satpam Token kita sebelum satpam bawaan Spring
            .addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}