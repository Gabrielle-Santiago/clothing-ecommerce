package com.gabrielle.ecommerce.application.mapper.product;

import com.gabrielle.ecommerce.domain.Product;
import com.gabrielle.ecommerce.domain.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductPersistenceMapper {
    @Mapping(target = "sellerId", source = "seller")
    Product toDomain(ProductEntity entity);

    @Mapping(target = "seller", source = "sellerId")
    ProductEntity toEntity(Product product);
}
