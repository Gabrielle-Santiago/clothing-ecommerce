package com.gabrielle.ecommerce.adapter.security.token.exception;

public class RefreshTokenRevoked extends RuntimeException {
    public RefreshTokenRevoked(String message) {
        super(message);
    }
}
