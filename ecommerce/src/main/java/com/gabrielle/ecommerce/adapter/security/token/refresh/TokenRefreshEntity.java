package com.gabrielle.ecommerce.adapter.security.token.refresh;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "refresh_tokens")
@Getter
@Setter
@NoArgsConstructor
public class TokenRefreshEntity {
    @Id
    @Column(name = "token", nullable = false, unique = true, length = 255)
    private String token;

    @Column(name = "user_id", nullable = false)
    private UUID user;

    @Column(name = "expiry_date", nullable = false)
    private Instant expiryDate;

    @Column(name = "revoked", nullable = false)
    private boolean revoked = false;

    public TokenRefreshEntity(String token, UUID user, Instant expiryDate) {
        this.token = token;
        this.user = user;
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return expiryDate.isBefore(Instant.now());
    }
}
