package com.gabrielle.ecommerce.mapper;

import com.gabrielle.ecommerce.model.dto.RegisterClientDTO;
import com.gabrielle.ecommerce.model.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", expression = "java(com.gabrielle.ecommerce.model.enums.UserRole.CLIENT)")
    @Mapping(target = "passwd", expression = "java(new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode(clientDTO.passwd()))")
    ClientEntity toEntity(RegisterClientDTO clientDTO);
}
