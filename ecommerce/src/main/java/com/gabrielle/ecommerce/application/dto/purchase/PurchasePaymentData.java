package com.gabrielle.ecommerce.application.dto.purchase;

import java.math.BigDecimal;
import java.util.UUID;

public record PurchasePaymentData(
        UUID purchaseId,
        BigDecimal total
) {}
