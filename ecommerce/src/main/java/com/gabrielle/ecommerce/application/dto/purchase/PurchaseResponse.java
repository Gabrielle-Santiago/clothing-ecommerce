package com.gabrielle.ecommerce.application.dto.purchase;

import com.gabrielle.ecommerce.domain.enums.PurchaseStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record PurchaseResponse(
        UUID purchaseId,
        UUID clientId,
        PurchaseStatus status,
        BigDecimal total,
        Instant createdAt,
        String paymentMethod,
        List<PurchaseItemResponse> items
) {}
