package com.gabrielle.ecommerce.domain;

import com.gabrielle.ecommerce.domain.annotation.Default;
import com.gabrielle.ecommerce.domain.enums.PurchaseStatus;
import com.gabrielle.ecommerce.shared.exception.ItemNotNullException;
import com.gabrielle.ecommerce.shared.exception.PaymentRequiredException;
import com.gabrielle.ecommerce.shared.exception.QuantityGreaterThanZeroException;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;

@Getter
public class Purchase {
    private UUID id;
    private final UUID clientId;
    private List<PurchaseItem> items = new ArrayList<>();
    private final String paymentMethod;
    private Instant createdAt;
    private PurchaseStatus status;
    private BigDecimal total;

    public Purchase(UUID clientId, String paymentMethod) {
        validateMethodPayment(paymentMethod);

        this.clientId = clientId;
        this.paymentMethod = paymentMethod;
    }

    @Default
    public Purchase(UUID id, UUID clientId, String paymentMethod, List<PurchaseItem> items) {
        this.id = id;
        this.clientId = clientId;
        this.paymentMethod = paymentMethod;
        this.items = List.copyOf(items);
        this.createdAt = Instant.now();
        this.status = PurchaseStatus.PENDING;
        this.total = calculateTotal();
    }

    public static Purchase createWithClient(UUID clientId, String paymentMethod) {
        return new Purchase(clientId, paymentMethod);
    }

    public void finalizePurchase() {
        this.createdAt = Instant.now();
        this.status = PurchaseStatus.PENDING;
        this.total = calculateTotal();
    }

    public BigDecimal calculateTotal(){
        if (items.isEmpty()){
            throw new QuantityGreaterThanZeroException("Purchase must have at least one item");
        }

        return items.stream()
                .map(PurchaseItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void validateMethodPayment(String paymentMethod){
        if (paymentMethod == null || paymentMethod.isBlank()) {
            throw new PaymentRequiredException("Payment method is required");
        }
    }

    public void addItem(PurchaseItem item) {
        if (item == null) {
            throw new ItemNotNullException("Item cannot be null");
        }
        items.add(item);
    }
}
