package com.gabrielle.ecommerce.exceptions.authentication;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
