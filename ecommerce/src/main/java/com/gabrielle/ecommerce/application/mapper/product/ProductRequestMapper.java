package com.gabrielle.ecommerce.application.mapper.product;

import com.gabrielle.ecommerce.application.dto.product.ProductRequestDTO;
import com.gabrielle.ecommerce.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductRequestMapper {
    @Mapping(target = "id", ignore = true)
    Product toDomain(ProductRequestDTO requestDTO);
}
