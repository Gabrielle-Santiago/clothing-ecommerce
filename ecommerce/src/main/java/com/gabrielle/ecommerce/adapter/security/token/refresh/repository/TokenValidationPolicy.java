package com.gabrielle.ecommerce.adapter.security.token.refresh.repository;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.gabrielle.ecommerce.adapter.security.token.exception.TokenRevokedException;
import com.gabrielle.ecommerce.adapter.security.token.refresh.TokenRefreshEntity;

public interface TokenValidationPolicy {
    void validate(TokenRefreshEntity token) throws TokenExpiredException, TokenRevokedException;
}
