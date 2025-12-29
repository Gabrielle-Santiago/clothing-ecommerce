package com.gabrielle.ecommerce.application.mapper.purchase;

import com.gabrielle.ecommerce.application.dto.purchase.PurchaseItemResponse;
import com.gabrielle.ecommerce.domain.Purchase;
import com.gabrielle.ecommerce.domain.PurchaseItem;
import com.gabrielle.ecommerce.domain.entity.Purchase.PurchaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PurchaseItemResponseMapper {
    @Mapping(target = "subtotal", expression = "java(item.getSubtotal())")
    PurchaseItemResponse toDTO(PurchaseItem item);

    @Mapping(target = "total", expression = "java(purchase.calculateTotal())")
    PurchaseEntity toEntity(Purchase purchase);
}
