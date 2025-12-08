package com.gabrielle.ecommerce.application.mapper;

import com.gabrielle.ecommerce.domain.Seller;
import com.gabrielle.ecommerce.domain.entity.user.SellerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SellerPersistenceMapper {
    SellerEntity toEntity(Seller seller);
    Seller toDomain(SellerEntity entity);
}
