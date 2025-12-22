package com.gabrielle.ecommerce.application.mapper.purchase;

import com.gabrielle.ecommerce.application.dto.purchase.PurchaseResponse;
import com.gabrielle.ecommerce.domain.Purchase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = PurchaseItemResponseMapper.class)
public interface PurchaseResponseMapper {
    @Mapping(target="purchaseId", source = "id")
    PurchaseResponse toDTO(Purchase domain);
}
