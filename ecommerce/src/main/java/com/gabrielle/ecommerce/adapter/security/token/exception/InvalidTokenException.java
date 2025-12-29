package com.gabrielle.ecommerce.adapter.security.token.exception;

public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException(String message) {
        super(message);
    }
}
