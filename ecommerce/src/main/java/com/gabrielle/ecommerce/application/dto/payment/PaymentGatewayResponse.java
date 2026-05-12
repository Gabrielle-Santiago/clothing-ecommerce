package com.gabrielle.ecommerce.application.dto.payment;

public record PaymentGatewayResponse(
        String checkoutUrl,
        String externalId
) {}
