package com.gabrielle.ecommerce.application.service.purchase;

import com.gabrielle.ecommerce.ports.repository.purchase.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeletePurchaseUseCase {
    public final PurchaseRepository repository;

    public DeletePurchaseUseCase(PurchaseRepository repository) {
        this.repository = repository;
    }

    public void execute(UUID id){ repository.deleteById(id); }
}
