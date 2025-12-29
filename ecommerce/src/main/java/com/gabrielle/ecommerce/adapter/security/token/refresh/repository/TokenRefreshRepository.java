package com.gabrielle.ecommerce.adapter.security.token.refresh.repository;

import com.gabrielle.ecommerce.adapter.security.token.refresh.TokenRefreshEntity;

import java.time.Instant;
import java.util.Optional;

public interface TokenRefreshRepository {
    Optional<TokenRefreshEntity> findById(String token);
    void save(TokenRefreshEntity token);
    void delete(TokenRefreshEntity token);
    void deleteTokenByExpirationDate(Instant now);
}
