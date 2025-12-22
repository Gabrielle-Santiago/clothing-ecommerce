package com.gabrielle.ecommerce.application.dto.purchase;

import java.math.BigDecimal;
import java.util.UUID;

public record PurchaseItemResponse(
        UUID productId,
        int quantity,
        BigDecimal unitPrice,
        BigDecimal subtotal
) {}
