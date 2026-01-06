package com.gabrielle.ecommerce.application.dto.purchase;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.UUID;

@Schema(
        name = "PurchaseItemResponse",
        description = "Item returned as part of a purchase response"
)
public record PurchaseItemResponse(

        @Schema(
                description = "Unique identifier of the product",
                example = "f47ac10b-58cc-4372-a567-0e02b2c3d479"
        )
        UUID productId,

        @Schema(
                description = "Quantity of the product purchased",
                example = "2"
        )
        int quantity,

        @Schema(
                description = "Unit price of the product at the time of purchase",
                example = "99.90"
        )
        BigDecimal unitPrice,

        @Schema(
                description = "Subtotal calculated for this item (unitPrice × quantity)",
                example = "199.80"
        )
        BigDecimal subtotal

) {}
