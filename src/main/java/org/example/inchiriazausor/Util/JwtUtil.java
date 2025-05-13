package org.example.inchiriazausor.Util;

import java.security.Key;
import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // cheie random, poți salva în config
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 oră

    public static String generateEmailConfirmationToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .claim("type", "email_confirmation")
                .signWith(key)
                .compact();
    }

    public static String generateAuthToken(UserDetails userDetails) {
        return Jwts.builder()
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 ore
            .signWith(key)
            .compact();
    }

    public static String extractEmailFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    
    // public boolean validateToken(String token, UserDetails userDetails) {
    //     String username = extractUsername(token);
    //     return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    // }

    // private boolean isTokenExpired(String token) {
    //     return Jwts.parser().setSigningKey(secret)
    //         .parseClaimsJws(token).getBody().getExpiration().before(new Date());
    // }
}
