package com.gabrielle.ecommerce.adapter.security.token.refresh;

import com.gabrielle.ecommerce.adapter.security.token.refresh.repository.TokenRefreshJpaRepository;
import com.gabrielle.ecommerce.adapter.security.token.refresh.repository.TokenRefreshRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Optional;

@Repository
public class TokenRefreshRepositoryAdapter implements TokenRefreshRepository {
    private final TokenRefreshJpaRepository jpaRepository;

    public TokenRefreshRepositoryAdapter(TokenRefreshJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<TokenRefreshEntity> findById(String token) {
        return jpaRepository.findById(token);
    }

    @Override
    public void save(TokenRefreshEntity token) {
        jpaRepository.save(token);
    }

    @Override
    public void delete(TokenRefreshEntity token) {
        jpaRepository.delete(token);
    }

    @Override
    public void deleteTokenByExpirationDate(Instant now) {
        jpaRepository.deleteTokenByExpirationDate(now);
    }
}
