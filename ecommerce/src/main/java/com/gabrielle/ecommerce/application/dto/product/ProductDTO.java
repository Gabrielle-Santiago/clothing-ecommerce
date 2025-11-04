package com.gabrielle.ecommerce.application.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ProductDTO {
    private UUID id;
    private String nameProduct;
    private String size;
    private int quant;
    private BigDecimal price;
    private String describe;
    private String img;
}
