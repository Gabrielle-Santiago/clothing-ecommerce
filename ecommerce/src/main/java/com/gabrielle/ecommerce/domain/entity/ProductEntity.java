package com.gabrielle.ecommerce.domain.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(name = "seller_id")
    private UUID seller;

    public ProductEntity(String nameProduct, String size, int quant, BigDecimal price, String describe, String img, UUID seller) {
        this.nameProduct = nameProduct;
        this.size = size;
        this.quant = quant;
        this.price = price;
        this.describe = describe;
        this.img = img;
        this.seller = seller;
    }
}
