package com.gabrielle.ecommerce.application.dto.purchase;

import com.gabrielle.ecommerce.domain.enums.PurchaseStatus;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Schema(
        name = "PurchaseResponse",
        description = "Response returned after retrieving or creating a purchase"
)
public record PurchaseResponse(

        @Schema(
                description = "Unique identifier of the purchase",
                example = "8a2f3c4d-9e3b-4a5f-9c2d-123456789abc"
        )
        UUID purchaseId,

        @Schema(
                description = "Unique identifier of the client who made the purchase",
                example = "550e8400-e29b-41d4-a716-446655440000"
        )
        UUID clientId,

        @Schema(
                description = "Current status of the purchase",
                example = "CREATED"
        )
        PurchaseStatus status,

        @Schema(
                description = "Total amount of the purchase",
                example = "199.80"
        )
        BigDecimal total,

        @Schema(
                description = "Date and time when the purchase was created",
                example = "2026-01-06T10:15:30Z"
        )
        Instant createdAt,

        @Schema(
                description = "Payment method used for the purchase",
                example = "CREDIT_CARD"
        )
        String paymentMethod,

        @Schema(
                description = "List of items included in the purchase"
        )
        List<PurchaseItemResponse> items

) {}
