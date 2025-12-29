package com.gabrielle.ecommerce.application.dto.purchase;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public record PurchaseRequest(
        @JsonProperty("clientId")
        UUID clientId,
        @JsonProperty("paymentMethod")
        String paymentMethod,
        @JsonProperty("items")
        List<PurchaseItemRequest> items
) {}
