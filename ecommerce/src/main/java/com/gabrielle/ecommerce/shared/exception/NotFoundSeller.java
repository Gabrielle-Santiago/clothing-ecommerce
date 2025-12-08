package com.gabrielle.ecommerce.shared.exception;

public class NotFoundSeller extends RuntimeException {
    public NotFoundSeller(String message) {
        super(message);
    }
}
