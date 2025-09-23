package com.gabrielle.ecommerce.exceptions;

import com.gabrielle.ecommerce.exceptions.authentication.InvalidCredentialsException;
import com.gabrielle.ecommerce.exceptions.authentication.NotFoundTokenException;
import com.gabrielle.ecommerce.exceptions.authentication.TokenGenerationException;
import com.gabrielle.ecommerce.exceptions.authentication.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TokenGenerationException.class)
    public ResponseEntity<String> handleTokenGeneration(TokenGenerationException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(NotFoundTokenException.class)
    public ResponseEntity<String> handleNotFoundTokenException(NotFoundTokenException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<String> handleInvalidCredentialsException(InvalidCredentialsException ex){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }
}
