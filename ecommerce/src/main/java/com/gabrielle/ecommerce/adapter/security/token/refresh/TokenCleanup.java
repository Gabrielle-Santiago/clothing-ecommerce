package com.gabrielle.ecommerce.adapter.security.token.refresh;

import com.gabrielle.ecommerce.adapter.security.token.refresh.repository.TokenRefreshRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TokenCleanup {
    private final TokenRefreshRepository repository;

    public TokenCleanup(TokenRefreshRepository repository) {
        this.repository = repository;
    }

    @Scheduled(cron = "0 0 * * * *")
    public void removeExpiredTokens(){
        repository.deleteTokenByExpirationDate(Instant.now());
    }
}
