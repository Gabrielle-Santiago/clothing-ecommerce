package com.gabrielle.ecommerce.adapter.security.token.refresh.repository;

import com.gabrielle.ecommerce.adapter.security.token.refresh.TokenRefreshEntity;
import com.gabrielle.ecommerce.adapter.security.token.refresh.dto.TokenRefreshDTO;
import java.time.Instant;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-22T10:50:38-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class TokenRefreshMapperImpl implements TokenRefreshMapper {

    @Override
    public TokenRefreshDTO toDomain(TokenRefreshEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID user = null;
        String token = null;
        Instant expiryDate = null;

        user = entity.getUser();
        token = entity.getToken();
        expiryDate = entity.getExpiryDate();

        TokenRefreshDTO tokenRefreshDTO = new TokenRefreshDTO( token, user, expiryDate );

        tokenRefreshDTO.setRevoked( entity.isRevoked() );

        return tokenRefreshDTO;
    }

    @Override
    public TokenRefreshEntity toEntity(TokenRefreshDTO domain) {
        if ( domain == null ) {
            return null;
        }

        TokenRefreshEntity tokenRefreshEntity = new TokenRefreshEntity();

        tokenRefreshEntity.setUser( domain.getUser() );
        tokenRefreshEntity.setToken( domain.getToken() );
        tokenRefreshEntity.setExpiryDate( domain.getExpiryDate() );
        tokenRefreshEntity.setRevoked( domain.isRevoked() );

        return tokenRefreshEntity;
    }
}
