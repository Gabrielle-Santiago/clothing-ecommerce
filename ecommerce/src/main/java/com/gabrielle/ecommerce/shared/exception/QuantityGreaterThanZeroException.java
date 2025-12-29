package com.gabrielle.ecommerce.shared.exception;

public class QuantityGreaterThanZeroException extends RuntimeException {
    public QuantityGreaterThanZeroException(String message) {
        super(message);
    }
}
