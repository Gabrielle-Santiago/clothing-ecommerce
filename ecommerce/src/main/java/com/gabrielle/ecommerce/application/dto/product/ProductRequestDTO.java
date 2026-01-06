package com.gabrielle.ecommerce.application.dto.product;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(
        name = "ProductRequest",
        description = "Request payload used to create or update a product"
)
public record ProductRequestDTO(

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
                example = "100"
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
