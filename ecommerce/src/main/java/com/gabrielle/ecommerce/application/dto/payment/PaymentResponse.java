package com.gabrielle.ecommerce.application.dto.payment;

import java.math.BigDecimal;

public record PaymentResponse(
        String checkoutUrl,
        String externalId,
        BigDecimal amount
) {}