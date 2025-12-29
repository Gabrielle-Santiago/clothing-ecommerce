package com.gabrielle.ecommerce.adapter.security.token.refresh.policy;

import com.gabrielle.ecommerce.adapter.security.token.exception.RefreshTokenRevoked;
import com.gabrielle.ecommerce.adapter.security.token.exception.TokenExpiredException;
import com.gabrielle.ecommerce.adapter.security.token.refresh.TokenRefreshEntity;
import com.gabrielle.ecommerce.adapter.security.token.refresh.repository.TokenValidationPolicy;
import org.springframework.stereotype.Service;

@Service
public class DefaultTokenValidationPolicy implements TokenValidationPolicy {

    @Override
    public void validate(TokenRefreshEntity token) {
        if(token.isExpired()){
            throw new TokenExpiredException("Refresh Token expired");
        }
        if(token.isRevoked()){
            throw new RefreshTokenRevoked("Refresh Token revoked.");
        }
    }
}
