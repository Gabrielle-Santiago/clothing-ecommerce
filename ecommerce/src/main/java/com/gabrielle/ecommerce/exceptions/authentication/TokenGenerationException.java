package com.gabrielle.ecommerce.exceptions.authentication;

public class TokenGenerationException extends RuntimeException{
    public TokenGenerationException(String message){
        super(message);
    }
}
