package com.gabrielle.ecommerce.adapter.security.token.refresh.repository;

import com.gabrielle.ecommerce.adapter.security.token.refresh.dto.TokenRefreshResponse;

public interface TokenRefreshCommand {
    TokenRefreshResponse refresh(String oldRefreshToken);
}
