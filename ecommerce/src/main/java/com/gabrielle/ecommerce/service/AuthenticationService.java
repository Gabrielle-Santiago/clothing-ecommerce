package com.gabrielle.ecommerce.service;

import com.gabrielle.ecommerce.exceptions.authentication.InvalidCredentialsException;
import com.gabrielle.ecommerce.model.dto.LoginDTO;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticationService(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    public String authenticateUser(LoginDTO dto) throws AuthenticationException {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dto.username(), dto.passwd());

        try {
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            return tokenService.generateToken(userDetails);
        } catch (BadCredentialsException ex) {
            throw new InvalidCredentialsException("Invalid username or passwor: " + ex);
        } catch (DisabledException | LockedException | AccountExpiredException ex) {
            throw new RuntimeException("Error disabled or locked or acount expired", ex);
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred during authentication. Please try again later.", e);
        }
    }
}
