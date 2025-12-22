package com.gabrielle.ecommerce.shared.exception;

public class PriceGreaterThanZeroException extends RuntimeException {
    public PriceGreaterThanZeroException(String message) {
        super(message);
    }
}
