package com.gabrielle.ecommerce.application.dto.payment;

import java.util.UUID;

public record PaymentRequest(
        UUID purchaseId,
        String payerEmail
) {}
