package com.gabrielle.ecommerce.application.dto.purchase;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import org.springframework.data.annotation.Id;

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
        @Id
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
        @Column(precision = 10, scale = 2)
        BigDecimal unitPrice,

        @Schema(
                description = "Subtotal calculated for this item (unitPrice × quantity)",
                example = "199.80"
        )
        @Column(precision = 10, scale = 2)
        BigDecimal subtotal

) {}
