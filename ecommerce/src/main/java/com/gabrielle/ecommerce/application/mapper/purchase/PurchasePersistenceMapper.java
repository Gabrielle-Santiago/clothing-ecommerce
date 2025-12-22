package com.gabrielle.ecommerce.application.mapper.purchase;

import com.gabrielle.ecommerce.domain.*;
import com.gabrielle.ecommerce.domain.entity.Purchase.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PurchasePersistenceMapper {

    @Mapping(target = "paymentMethod", source = "paymentMethod")
    Purchase toDomain(PurchaseEntity entity);
    @Mapping(target = "paymentMethod", source = "paymentMethod")
    PurchaseEntity toEntity(Purchase purchase);


    @Mapping(target = "purchase", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "productName", ignore = true)
    PurchaseItemEntity toItemEntity(PurchaseItem domainItem);
    PurchaseItem toItemDomain(PurchaseItemEntity entityItem);
}
