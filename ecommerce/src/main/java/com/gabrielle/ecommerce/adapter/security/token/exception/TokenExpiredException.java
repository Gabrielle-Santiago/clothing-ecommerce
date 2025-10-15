package com.gabrielle.ecommerce.adapter.security.token.exception;

public class TokenExpiredException extends RuntimeException {
    public TokenExpiredException(String message) {
        super(message);
    }
}
