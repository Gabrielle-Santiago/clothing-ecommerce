package com.gabrielle.ecommerce.application.mapper.product;

import com.gabrielle.ecommerce.domain.Product;
import com.gabrielle.ecommerce.domain.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductPersistenceMapper {
    ProductEntity toEntity(Product domain);
    Product toDomain(ProductEntity entity);
}
