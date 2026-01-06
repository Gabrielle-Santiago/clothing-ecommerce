package com.gabrielle.ecommerce.application.dto.product;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.UUID;

@Schema(
        name = "ProductResponse",
        description = "Product data returned by the API"
)
public record ProductResponseDTO(

        @Schema(
                description = "Unique identifier of the product",
                example = "3fa85f64-5717-4562-b3fc-2c963f66afa6"
        )
        UUID id,

        @Schema(
                description = "Product name",
                example = "Oversized T-Shirt"
        )
        String nameProduct,

        @Schema(
                description = "Product size",
                example = "M"
        )
        String size,

        @Schema(
                description = "Available quantity in stock",
                example = "50"
        )
        int quant,

        @Schema(
                description = "Product unit price",
                example = "79.90"
        )
        BigDecimal price,

        @Schema(
                description = "Product description",
                example = "Black oversized t-shirt made of 100% cotton"
        )
        String describe,

        @Schema(
                description = "URL of the product image",
                example = "https://example.com/images/product.png"
        )
        String img

) {}
