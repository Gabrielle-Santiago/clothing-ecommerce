package com.gabrielle.ecommerce.application.dto.product;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponseDTO(
        UUID id,
        String nameProduct,
        String size,
        int quant,
        BigDecimal price,
        String describe,
        String img
) {}
