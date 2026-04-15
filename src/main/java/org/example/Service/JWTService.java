package org.example.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.example.Entity.LoginRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class JWTService {
    private static final String SECRET_KEY = "YOUR_BASE64_ENCODED_SECRET_KEY_HERE";

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String generateToken(String email, Long customerId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", email);
        claims.put("customer_id", customerId);

        return Jwts.builder()
                .claims(claims)
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(getSigningKey())
                .compact();
    }
    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String extractEmail(String token) {
        Claims claims = extractAllClaims(token);

        // either from custom claim
        String email = claims.get("email", String.class);

        // fallback to subject if needed
        if (email == null) {
            email = claims.getSubject();
        }

        return email;
    }

    public Long extractCustomerId(String token) {
        Claims claims = extractAllClaims(token);
        return claims.get("customer_id", Long.class);
    }

    public boolean isTokenValid(String token, String email) {
        String extractedEmail = extractEmail(token);
        Date expiration = extractAllClaims(token).getExpiration();

        return extractedEmail.equals(email) && expiration.after(new Date());
    }

}
