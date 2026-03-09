package com.gabrielle.ecommerce.application.service.purchase;

import com.gabrielle.ecommerce.domain.Purchase;
import com.gabrielle.ecommerce.ports.repository.purchase.PurchaseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class PurchaseService {
    private final PurchaseRepository repository;

    public PurchaseService(PurchaseRepository repository) {
        this.repository = repository;
    }

    public Purchase getPurchase(UUID id) {
        return repository.findById(id);
    }

    public void approve(UUID id) {
        Purchase purchase = getPurchase(id);
        purchase.approve();
        repository.save(purchase);
    }

    public void startPayment(UUID id){
        Purchase purchase = getPurchase(id);
        purchase.markAsPending();
        repository.save(purchase);
    }

    public void reject(UUID id){
        Purchase purchase = getPurchase(id);
        purchase.reject();
        repository.save(purchase);
    }

    public void cancel(UUID id){
        Purchase purchase = getPurchase(id);
        purchase.cancel();
        repository.save(purchase);
    }
}
