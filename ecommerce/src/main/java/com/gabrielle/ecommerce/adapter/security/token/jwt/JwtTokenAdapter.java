package com.gabrielle.ecommerce.adapter.security.token.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gabrielle.ecommerce.adapter.security.token.port.TokenProviderPort;
import com.gabrielle.ecommerce.adapter.security.token.exception.TokenGenerationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.*;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtTokenAdapter implements TokenProviderPort {
    private static final String ISSUER = "auth-api";
    private final Algorithm algorithm;
    private final long accessExpirationHours;
    private final long refreshExpirationDays;

    public JwtTokenAdapter(
            @Value("${api.security.token.secret}") String secret,
            @Value("${api.security.token.access-expiration-hours:2}") long accessExpirationHours,
            @Value("${api.security.token.refresh-expiration-days:7}") long refreshExpirationDays
    ) {
        this.algorithm = Algorithm.HMAC256(secret);
        this.accessExpirationHours = accessExpirationHours;
        this.refreshExpirationDays = refreshExpirationDays;
    }

    private String createToken(String subject, Instant expiry) {
        try{
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(subject)
                    .withExpiresAt(Date.from(expiry))
                    .sign(algorithm);
        } catch(JWTCreationException e){
            throw new TokenGenerationException("Error creating token: " + e);
        }
    }

    @Override
    public String generateAccessToken(UUID userId) {
        Instant expiry = generateExpirationDate(accessExpirationHours, 0);
        return createToken(userId.toString(), expiry);
    }

    @Override
    public String generateRefreshToken(UUID userId) {
        Instant expiry = generateExpirationDate(0, refreshExpirationDays);
        return createToken(String.valueOf(userId), expiry);
    }

    @Override
    public UUID getUserIdFromToken(String token) {
        try{
            DecodedJWT jwt = JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(token);

            String subject = jwt.getSubject();
            return UUID.fromString(subject);
        } catch (JWTVerificationException | IllegalArgumentException ex) {
            return null;
        }
    }

    private Instant generateExpirationDate(long hours, long days) {
        return LocalDateTime.now(ZoneOffset.UTC)
                .plusHours(hours)
                .plusDays(days)
                .toInstant(ZoneOffset.UTC);
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
}
