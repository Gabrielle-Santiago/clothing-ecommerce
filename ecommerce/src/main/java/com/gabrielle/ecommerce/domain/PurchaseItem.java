package com.gabrielle.ecommerce.domain;

import com.gabrielle.ecommerce.shared.exception.PriceGreaterThanZeroException;
import com.gabrielle.ecommerce.shared.exception.ProductNotFoundException;
import com.gabrielle.ecommerce.shared.exception.QuantityGreaterThanZeroException;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class PurchaseItem {
    private final UUID productId;
    private final int quantity;
    private final BigDecimal unitPrice;

    public PurchaseItem(UUID productId, int quantity, BigDecimal unitPrice) {
        if (quantity <= 0) {
            throw new QuantityGreaterThanZeroException("Quantity must be greater than zero");
        }
        if (unitPrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new PriceGreaterThanZeroException("Unit price must be greater than zero");
        }
        if (productId == null) {
            throw new ProductNotFoundException("ProductId not found");
        }

        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public BigDecimal getSubtotal() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }
}
