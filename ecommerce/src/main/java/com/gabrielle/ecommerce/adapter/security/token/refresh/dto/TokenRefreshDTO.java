package com.gabrielle.ecommerce.adapter.security.token.refresh.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class TokenRefreshDTO {
    private String token;
    private UUID user;
    private Instant expiryDate;
    private boolean revoked;

    public TokenRefreshDTO(String token, UUID user, Instant expiryDate) {
        this.token = token;
        this.user = user;
        this.expiryDate = expiryDate;
        this.revoked = false;
    }

    public boolean isExpired() {
        return expiryDate.isBefore(Instant.now());
    }
}
