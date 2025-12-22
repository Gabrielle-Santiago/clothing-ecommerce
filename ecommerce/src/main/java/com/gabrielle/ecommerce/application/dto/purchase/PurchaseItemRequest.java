package com.gabrielle.ecommerce.application.dto.purchase;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.UUID;

public record PurchaseItemRequest(
        @JsonProperty("productId")
        UUID productId,
        @JsonProperty("quantity")
        int quantity,
        @JsonProperty("unitPrice")
        BigDecimal unitPrice
) {}
