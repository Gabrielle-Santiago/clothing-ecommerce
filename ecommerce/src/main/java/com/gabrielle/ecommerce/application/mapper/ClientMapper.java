package com.gabrielle.ecommerce.application.mapper;

import com.gabrielle.ecommerce.application.dto.user.RegisterClientDTO;
import com.gabrielle.ecommerce.domain.entity.user.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", expression = "java(com.gabrielle.ecommerce.domain.enums.UserRole.CLIENT)")
    @Mapping(target = "passwd", expression = "java(new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode(clientDTO.passwd()))")
    ClientEntity toEntity(RegisterClientDTO clientDTO);
}
