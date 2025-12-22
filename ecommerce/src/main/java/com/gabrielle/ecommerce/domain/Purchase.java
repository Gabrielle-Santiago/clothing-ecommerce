package com.gabrielle.ecommerce.domain;

import com.gabrielle.ecommerce.domain.annotation.Default;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.*;

@Getter
public class Purchase {
    private UUID id;
    private final UUID clientId;
    private final List<PurchaseItem> items = new ArrayList<>();
    private final String paymentMethod;

    public Purchase(UUID clientId, String paymentMethod) {
        validateMethodPayment(paymentMethod);

        this.clientId = clientId;
        this.paymentMethod = paymentMethod;
    }

    @Default
    public Purchase(UUID id, UUID clientId, String paymentMethod) {
        validateMethodPayment(paymentMethod);

        this.id = id;
        this.clientId = clientId;
        this.paymentMethod = paymentMethod;
    }

    public static Purchase createWithClient(UUID clientId, String paymentMethod) {
        return new Purchase(clientId, paymentMethod);
    }

    public BigDecimal calculateTotal(){
        if (items.isEmpty()){
            throw new IllegalArgumentException("Purchase must have at least one item");
        }

        return items.stream()
                .map(PurchaseItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void validateMethodPayment(String paymentMethod){
        if (paymentMethod == null || paymentMethod.isBlank()) {
            throw new IllegalArgumentException("Payment method is required");
        }
    }

    public void addItem(PurchaseItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        items.add(item);
    }
}
