package com.gabrielle.ecommerce.adapter.security.token.exception;

public class TokenRevokedException extends RuntimeException {
    public TokenRevokedException(String message) {
        super(message);
    }
}
