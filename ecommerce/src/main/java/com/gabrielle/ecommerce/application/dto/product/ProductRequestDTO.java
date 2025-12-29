package com.gabrielle.ecommerce.application.dto.product;

import java.math.BigDecimal;

public record ProductRequestDTO(
        String nameProduct,
        String size,
        int quant,
        BigDecimal price,
        String describe,
        String img
) {}
