package com.gabrielle.ecommerce.application.dto.purchase;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.UUID;

@Schema(
        name = "PurchaseRequest",
        description = "Request payload used to create a new purchase"
)
public record PurchaseRequest(

        @Schema(
                description = "Unique identifier of the client who is making the purchase",
                example = "550e8400-e29b-41d4-a716-446655440000"
        )
        @JsonProperty("clientId")
        @Id
        UUID clientId,

        @Schema(
                description = "Payment method used for the purchase",
                example = "CREDIT_CARD"
        )
        @JsonProperty("paymentMethod")
        String paymentMethod,

        @Schema(
                description = "List of items included in the purchase"
        )
        @JsonProperty("items")
        List<PurchaseItemRequest> items

) {}

