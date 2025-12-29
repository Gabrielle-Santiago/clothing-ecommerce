package com.gabrielle.ecommerce.adapter.security.token.refresh.repository;

import com.gabrielle.ecommerce.adapter.security.token.refresh.dto.TokenRefreshDTO;
import com.gabrielle.ecommerce.adapter.security.token.refresh.TokenRefreshEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TokenRefreshMapper {
    @Mapping(source = "user", target = "user")
    TokenRefreshDTO toDomain(TokenRefreshEntity entity);

    @Mapping(source = "user", target = "user")
    TokenRefreshEntity toEntity(TokenRefreshDTO domain);
}
