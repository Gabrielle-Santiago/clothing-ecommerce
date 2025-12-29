package com.gabrielle.ecommerce.adapter.security.token.exception;

public class TokenGenerationException extends RuntimeException{
    public TokenGenerationException(String message){
        super(message);
    }
}
