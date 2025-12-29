package com.gabrielle.ecommerce.adapter.security.token.port;

import java.util.UUID;

public interface TokenProviderPort {
    String generateRefreshToken(UUID userId);
    String generateAccessToken(UUID userId);
    UUID getUserIdFromToken(String token);
}
