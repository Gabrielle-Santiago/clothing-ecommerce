package com.gabrielle.ecommerce.application.mapper;

import com.gabrielle.ecommerce.application.dto.RegisterSellerDTO;
import com.gabrielle.ecommerce.domain.entity.SellerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SellerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", expression = "java(com.gabrielle.ecommerce.domain.enums.UserRole.SELLER)")
    @Mapping(target = "passwd", expression = "java(new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode(sellerDTO.passwd()))")
    SellerEntity toEntity(RegisterSellerDTO sellerDTO);
}
