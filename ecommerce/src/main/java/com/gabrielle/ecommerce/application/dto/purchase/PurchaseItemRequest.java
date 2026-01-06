package com.gabrielle.ecommerce.application.dto.purchase;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.UUID;

@Schema(
        name = "PurchaseItemRequest",
        description = "Item included in a purchase request"
)
public record PurchaseItemRequest(

        @Schema(
                description = "Unique identifier of the product",
                example = "f47ac10b-58cc-4372-a567-0e02b2c3d479"
        )
        @JsonProperty("productId")
        UUID productId,

        @Schema(
                description = "Quantity of the product being purchased",
                example = "2"
        )
        @JsonProperty("quantity")
        int quantity,

        @Schema(
                description = "Unit price of the product at the time of purchase",
                example = "99.90"
        )
        @JsonProperty("unitPrice")
        BigDecimal unitPrice

) {}
