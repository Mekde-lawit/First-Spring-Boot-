package com.api.demo.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.api.demo.config.JwtConfig;
import com.api.demo.models.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JwtService {

    private final JwtConfig jwtConfig;

    public Jwt generateAccessToken(User user) {
        return generateToken(user, jwtConfig.getAccessTokenExpiration());
    }

    public Jwt generateRefreshToken(User user) {
        return generateToken(user, jwtConfig.getRefreshTokenExpiration());
    }

    public Jwt generateToken(User user, long tokenExpiration) {
        var claims = Jwts.claims()
                .subject(user.getId().toString())
                .add("email", user.getEmail())
                .add("name", user.getName())
                .add("role", user.getRole())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * tokenExpiration))
                .build();
        return new Jwt(claims, jwtConfig.getSecretKey());
    }

    /*
     * public boolean validateToken(String token) {
     * try {
     * var claims = Jwts.parser()
     * .verifyWith(jwtConfig.getSecretKey())
     * .build()
     * .parseSignedClaims(token)
     * .getPayload();
     * return claims.getExpiration().after(new Date());
     * } catch (JwtException e) {
     * return false;
     * }
     * }
     */

    /*
     * public Long extractUserId(String token) {
     * return Long.valueOf(getClaims(token).getSubject());
     * }
     */

    private Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(jwtConfig.getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public Jwt parseToken(String token) {
        try {
            var claims = getClaims(token);
            return new Jwt(claims, jwtConfig.getSecretKey());
        } catch (Exception e) {
            return null; // or throw a custom exception
        }
    }

    /*
     * public Role getRoleFromToken(String token) {
     * var claims = getClaims(token);
     * return Role.valueOf(claims.get("role", String.class));
     * }
     */
}

// openssl rand -base64 32

// JwtConfig