package com.gabrielle.ecommerce.adapter.security.auth;

import com.gabrielle.ecommerce.adapter.security.token.port.LoginProviderPort;
import com.gabrielle.ecommerce.adapter.security.token.port.TokenProviderPort;
import com.gabrielle.ecommerce.adapter.security.token.refresh.TokenRefreshEntity;
import com.gabrielle.ecommerce.adapter.security.token.refresh.dto.TokenRefreshResponse;
import com.gabrielle.ecommerce.adapter.security.token.refresh.repository.TokenRefreshRepository;
import com.gabrielle.ecommerce.application.dto.LoginDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AuthenticateLoginUseCase {
    private final LoginProviderPort loginProvider;
    private final TokenProviderPort tokenProvider;
    private final TokenRefreshRepository refreshRepository;

    @Value("${api.security.token.expiration-seconds}")
    private long refreshTokenExpirationSeconds;

    public AuthenticateLoginUseCase(LoginProviderPort loginProvider, TokenProviderPort tokenProvider,
                                    TokenRefreshRepository refreshRepository) {
        this.loginProvider = loginProvider;
        this.tokenProvider = tokenProvider;
        this.refreshRepository = refreshRepository;
    }

    public TokenRefreshResponse execute(@Valid LoginDTO dto) {
        AuthenticatedUser user = loginProvider.authenticate(dto.username(), dto.passwd());

        String accessToken = tokenProvider.generateAccessToken(user.getUserId());
        String refreshToken = tokenProvider.generateRefreshToken(user.getUserId());

        Instant expiry = Instant.now().plusSeconds(refreshTokenExpirationSeconds);
        TokenRefreshEntity entity = new TokenRefreshEntity(refreshToken, user.getUserId(), expiry);
        refreshRepository.save(entity);

        return new TokenRefreshResponse(accessToken, refreshToken, expiry);
    }
}
