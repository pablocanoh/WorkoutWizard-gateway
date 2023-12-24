package com.example.workoutwizardgateway.configuration;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;
import java.util.function.Function;

public class JwtTokenUtil {

    private final SecretKey secretKey; // Initialize this with your secret key

    public JwtTokenUtil() {
        byte[] decodedKey = Base64.getDecoder().decode(System.getenv("JWT_USER_MS_KEY"));
        this.secretKey = Keys.hmacShaKeyFor(decodedKey);
    }

    public Boolean validateToken(String token) {
        return !isTokenExpired(token);
    }

    public Boolean isTokenExpired(String token) {
        final Date expiration = getClaimFromToken(token, Claims::getExpiration);
        return expiration.before(new Date());
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    public UUID getUserIdFromToken(String token) {
        return UUID.fromString(getAllClaimsFromToken(token).get("userId", String.class));
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build().parseSignedClaims(token).
                getPayload();
    }
}
