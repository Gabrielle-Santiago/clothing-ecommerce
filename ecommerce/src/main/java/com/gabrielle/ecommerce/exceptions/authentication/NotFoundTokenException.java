package com.gabrielle.ecommerce.exceptions.authentication;

public class NotFoundTokenException extends RuntimeException {
    public NotFoundTokenException(String message) {
        super(message);
    }
}
