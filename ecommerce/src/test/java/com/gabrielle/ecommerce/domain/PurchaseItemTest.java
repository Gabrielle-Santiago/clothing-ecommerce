package com.gabrielle.ecommerce.domain;

import com.gabrielle.ecommerce.shared.exception.PriceGreaterThanZeroException;
import com.gabrielle.ecommerce.shared.exception.ProductNotFoundException;
import com.gabrielle.ecommerce.shared.exception.QuantityGreaterThanZeroException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseItemTest {

    @Test
    void shouldCalculateSubtotalWhenQuantityIsGreaterThanZero() {
        UUID productId = UUID.randomUUID();
        int quantity = 3;
        BigDecimal unitPrice = new BigDecimal("12.00");

        PurchaseItem item = new PurchaseItem(productId, quantity, unitPrice);

        assertEquals(new BigDecimal("36.00"), item.getSubtotal());
    }

    @Test
    void shouldThrowExceptionWhenQuantityIsZero() {
        UUID productId = UUID.randomUUID();
        int quantity = 0;
        BigDecimal unitPrice = new BigDecimal("12.00");

        assertThrows(
                QuantityGreaterThanZeroException.class,
                () -> new PurchaseItem(productId, quantity, unitPrice)
        );
    }

    @Test
    void shouldThrowExceptionWhenProductIdIsNull() {
        UUID productId = null;
        int quantity = 3;
        BigDecimal unitPrice = new BigDecimal("12.00");

        assertThrows(
                ProductNotFoundException.class,
                () -> new PurchaseItem(productId, quantity, unitPrice)
        );
    }

    @Test
    void shouldThrowExceptionWhenUnitPriceIsZeroOrNegative() {
        UUID productId = UUID.randomUUID();
        int quantity = 3;
        BigDecimal unitPrice = BigDecimal.ZERO;

        assertThrows(
                PriceGreaterThanZeroException.class,
                () -> new PurchaseItem(productId, quantity, unitPrice)
        );
    }
}