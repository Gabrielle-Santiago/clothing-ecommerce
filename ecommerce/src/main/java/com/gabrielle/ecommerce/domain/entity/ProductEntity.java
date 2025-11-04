package com.gabrielle.ecommerce.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    private String nameProduct;
    private String size;
    private int quant;
    private BigDecimal price;
    private String describe;
    private String img;

    public ProductEntity(String nameProduct, String size, int quant, BigDecimal price, String describe, String img) {
        this.nameProduct = nameProduct;
        this.size = size;
        this.quant = quant;
        this.price = price;
        this.describe = describe;
        this.img = img;
    }
}
