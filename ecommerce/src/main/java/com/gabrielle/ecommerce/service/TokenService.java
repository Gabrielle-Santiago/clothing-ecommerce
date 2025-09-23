package com.gabrielle.ecommerce.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gabrielle.ecommerce.exceptions.authentication.TokenGenerationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {
    private static final String ISSUER = "auth-api";
    private final Algorithm algorithm;
    private final long expirationHours;

    public TokenService(
            @Value("${api.security.token.secret}") String secret,
            @Value("${api.security.token.expiration-hours:2}") long expirationHours
    ) {
        this.algorithm = Algorithm.HMAC256(secret);
        this.expirationHours = expirationHours;
    }

    public String generateToken(UserDetails user){
        try{
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(user.getUsername())
                    .withExpiresAt(Date.from(generateExpirationDate()))
                    .sign(algorithm);
        } catch(JWTCreationException e){
            throw new TokenGenerationException("Error creating token: " + e);
        }
    }

    public String validateToken(String token) {
        try {
            DecodedJWT jwt = JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(token);
            return jwt.getSubject();
        } catch (JWTVerificationException e) {
            return null;
        }
    }

    private Instant generateExpirationDate() {
        return LocalDateTime.now(ZoneOffset.UTC)
                .plusHours(expirationHours)
                .toInstant(ZoneOffset.UTC);
    }
}
