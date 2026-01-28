package com.gabrielle.ecommerce.domain;

import com.gabrielle.ecommerce.domain.enums.PurchaseStatus;
import com.gabrielle.ecommerce.shared.exception.ItemNotNullException;
import com.gabrielle.ecommerce.shared.exception.PaymentRequiredException;
import com.gabrielle.ecommerce.shared.exception.QuantityGreaterThanZeroException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseTest {

    @Test
    void finalizePurchase_shouldSetCreatedAtStatusAndTotal_whenItemsExist() {
        UUID id = UUID.randomUUID();
        UUID clientId = UUID.randomUUID();
        PurchaseItem item = new PurchaseItem(UUID.randomUUID(), 2, new BigDecimal("10.00"));

        Purchase purchase = new Purchase(id, clientId, "CREDIT", List.of(item));

        purchase.finalizePurchase();

        assertNotNull(purchase.getCreatedAt());
        assertEquals(PurchaseStatus.PENDING, purchase.getStatus());
        assertEquals(new BigDecimal("20.00"), purchase.getTotal());
    }

    @Test
    void calculateTotal_shouldReturnSumOfSubtotals_whenItemsExist() {
        PurchaseItem item1 = new PurchaseItem(UUID.randomUUID(), 2, new BigDecimal("10.00"));
        PurchaseItem item2 = new PurchaseItem(UUID.randomUUID(), 1, new BigDecimal("5.00"));

        Purchase purchase = new Purchase(UUID.randomUUID(), UUID.randomUUID(), "PIX", List.of(item1, item2));

        assertEquals(new BigDecimal("25.00"), purchase.calculateTotal());
    }

    @Test
    void calculateTotal_shouldThrowException_whenItemListIsEmpty() {
        Purchase purchase = new Purchase(UUID.randomUUID(), "PIX");

        assertThrows(
                QuantityGreaterThanZeroException.class,
                purchase::calculateTotal
        );
    }

    @Test
    void constructor_shouldCreatePurchase_whenPaymentMethodIsValid() {
        Purchase purchase = Purchase.createWithClient(UUID.randomUUID(), "CREDIT");

        assertEquals("CREDIT", purchase.getPaymentMethod());
    }

    @Test
    void constructor_shouldThrowException_whenPaymentMethodIsNullOrBlank() {
        assertThrows(
                PaymentRequiredException.class,
                () -> Purchase.createWithClient(UUID.randomUUID(), null)
        );

        assertThrows(
                PaymentRequiredException.class,
                () -> Purchase.createWithClient(UUID.randomUUID(), " ")
        );
    }

    @Test
    void addItem_shouldAddItemToPurchase_whenItemIsValid() {
        Purchase purchase = new Purchase(UUID.randomUUID(), "PIX");

        PurchaseItem item = new PurchaseItem(UUID.randomUUID(), 1, new BigDecimal("15.00"));
        purchase.addItem(item);

        assertEquals(1, purchase.getItems().size());
    }

    @Test
    void addItem_shouldThrowException_whenItemIsNull() {
        Purchase purchase = new Purchase(UUID.randomUUID(), "PIX");

        assertThrows(
                ItemNotNullException.class, () -> purchase.addItem(null)
        );
    }
}
