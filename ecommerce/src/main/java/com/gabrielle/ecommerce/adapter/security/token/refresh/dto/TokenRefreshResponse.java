package com.gabrielle.ecommerce.adapter.security.token.refresh.dto;

public record TokenRefreshResponse(String accessToken, String refreshToken, java.time.Instant expiryTime) {}
