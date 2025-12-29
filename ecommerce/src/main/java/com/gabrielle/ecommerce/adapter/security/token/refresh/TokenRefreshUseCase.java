package com.gabrielle.ecommerce.adapter.security.token.refresh;

import com.gabrielle.ecommerce.adapter.security.token.jwt.JwtTokenAdapter;
import com.gabrielle.ecommerce.adapter.security.token.exception.InvalidTokenException;
import com.gabrielle.ecommerce.adapter.security.token.exception.TokenNotFoundException;
import com.gabrielle.ecommerce.adapter.security.token.refresh.dto.TokenRefreshResponse;
import com.gabrielle.ecommerce.adapter.security.token.refresh.repository.*;
import com.gabrielle.ecommerce.adapter.security.token.port.TokenProviderPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class TokenRefreshUseCase implements TokenRefreshCommand {
    private final TokenRefreshRepository repository;
    private final TokenProviderPort tokenProvider;
    private final TokenValidationPolicy tokenValidationPolicy;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenAdapter tokenAdapter;

    @Value("${api.security.token.expiration-seconds}")
    private long refreshTokenExpirationSeconds;

    public TokenRefreshUseCase(TokenRefreshRepository repository, TokenProviderPort tokenProvider,
                               TokenValidationPolicy tokenValidationPolicy,
                               AuthenticationManager authenticationManager, JwtTokenAdapter tokenAdapter) {
        this.repository = repository;
        this.tokenProvider = tokenProvider;
        this.tokenValidationPolicy = tokenValidationPolicy;
        this.authenticationManager = authenticationManager;
        this.tokenAdapter = tokenAdapter;
    }

    @Override
    public TokenRefreshResponse refresh(String oldRefreshToken) {
        UUID userId = tokenProvider.getUserIdFromToken(oldRefreshToken);
        if(userId == null){
            throw new InvalidTokenException("Invalid token!");
        }

        TokenRefreshEntity token = repository.findById(oldRefreshToken)
                .orElseThrow(() -> new TokenNotFoundException("Session not found."));

        tokenValidationPolicy.validate(token);
        repository.delete(token);

        String newAcessToken = tokenProvider.generateAccessToken(userId);
        String newRefreshToken = tokenProvider.generateRefreshToken(userId);
        Instant expiryTime = Instant.now().plusSeconds(refreshTokenExpirationSeconds);

        TokenRefreshEntity newToken = new TokenRefreshEntity(newRefreshToken, userId, expiryTime);
        repository.save(newToken);

        return new TokenRefreshResponse(newAcessToken, newRefreshToken, expiryTime);
    }
}
