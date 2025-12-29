package com.gabrielle.ecommerce.shared.exception.authentication;

public class UserNotAuthenticatedException extends RuntimeException {
    public UserNotAuthenticatedException(String message) {
        super(message);
    }
}
