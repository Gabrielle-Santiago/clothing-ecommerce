package com.gabrielle.ecommerce.domain;

import com.gabrielle.ecommerce.domain.annotation.Default;
import com.gabrielle.ecommerce.shared.exception.PriceGreaterThanZeroException;
import com.gabrielle.ecommerce.shared.exception.QuantityGreaterThanZeroException;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class Product {
    private final UUID id;
    private String nameProduct;
    private String size;
    private int quant;
    private BigDecimal price;
    private String describe;
    private String img;
    private UUID sellerId;

    public Product(String nameProduct, String size, int quant, BigDecimal price, String describe, String img, UUID sellerId) {
        this(UUID.randomUUID(), nameProduct, size, quant, price, describe, img, sellerId);
    }

    @Default
    public Product(UUID id, String nameProduct, String size, int quant, BigDecimal price, String describe, String img, UUID sellerId) {
        validate(nameProduct, size, quant, price);

        this.id = id;
        this.nameProduct = nameProduct;
        this.size = size;
        this.quant = quant;
        this.price = price;
        this.describe = describe;
        this.img = img;
        this.sellerId = sellerId;
    }

    private void validate(String nameProduct, String size, int quant, BigDecimal price) {
        if (nameProduct == null || nameProduct.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be blank.");
        }
        if (size == null || size.isBlank()) {
            throw new IllegalArgumentException("Size cannot be blank.");
        }
        if (quant < 0) {
            throw new QuantityGreaterThanZeroException("Quantity cannot be negative.");
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new PriceGreaterThanZeroException("Price must be greater than zero.");
        }
    }

    public void update(String nameProduct, String size, int quant, BigDecimal price, String describe, String img) {
        validate(nameProduct, size, quant, price);
        this.nameProduct = nameProduct;
        this.size = size;
        this.quant = quant;
        this.price = price;
        this.describe = describe;
        this.img = img;
    }

    public void addStock(int quant) {
        if (quant < 0) {
            throw new IllegalArgumentException("Cannot add negative stock.");
        }
        this.quant += quant;
    }

    public void removeStock(int quant) {
        if (quant <= 0) {
            throw new IllegalArgumentException("Cannot remove zero or negative stock.");
        }
        if (this.quant < quant) {
            throw new IllegalArgumentException("Not enough stock available.");
        }
        this.quant -= quant;
    }
}
