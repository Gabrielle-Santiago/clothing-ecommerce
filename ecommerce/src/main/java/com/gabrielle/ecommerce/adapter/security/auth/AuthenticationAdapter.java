package com.gabrielle.ecommerce.adapter.security.auth;

import com.gabrielle.ecommerce.adapter.security.token.port.LoginProviderPort;
import com.gabrielle.ecommerce.domain.entity.user.UserEntity;
import com.gabrielle.ecommerce.ports.repository.UserRepository;
import com.gabrielle.ecommerce.shared.exception.authentication.InvalidCredentialsException;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationAdapter implements LoginProviderPort {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public AuthenticationAdapter(AuthenticationManager authenticationManager, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    @Override
    public AuthenticatedUser authenticate(String username, String passwd) {
        try {
            var authToken = new UsernamePasswordAuthenticationToken(username, passwd);
            Authentication authentication = authenticationManager.authenticate(authToken);

            UserEntity user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("User not found."));

            return new AuthenticatedUser(user.getId(), user.getUsername());
        } catch (BadCredentialsException e) {
            throw new InvalidCredentialsException("Invalid username or password.");
        }
    }
}
