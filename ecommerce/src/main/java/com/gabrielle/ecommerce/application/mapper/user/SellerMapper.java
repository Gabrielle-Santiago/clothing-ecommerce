package com.gabrielle.ecommerce.application.mapper.user;

import com.gabrielle.ecommerce.application.dto.user.RegisterSellerDTO;
import com.gabrielle.ecommerce.domain.entity.user.SellerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SellerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", expression = "java(com.gabrielle.ecommerce.domain.enums.UserRole.SELLER)")
    @Mapping(target = "passwd", expression = "java(new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode(sellerDTO.passwd()))")
    SellerEntity toEntity(RegisterSellerDTO sellerDTO);
}
