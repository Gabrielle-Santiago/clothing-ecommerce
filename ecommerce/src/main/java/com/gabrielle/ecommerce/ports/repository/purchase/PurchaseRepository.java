package com.gabrielle.ecommerce.ports.repository.purchase;

import com.gabrielle.ecommerce.domain.Purchase;

import java.util.List;
import java.util.UUID;

public interface PurchaseRepository {
    Purchase save(Purchase purchase);
    void deleteById(UUID id);
    List<Purchase> findAll();
}
