package com.gabrielle.ecommerce.application.service.purchase;

import com.gabrielle.ecommerce.application.dto.purchase.PurchaseResponse;
import com.gabrielle.ecommerce.application.mapper.purchase.PurchaseResponseMapper;
import com.gabrielle.ecommerce.domain.Purchase;
import com.gabrielle.ecommerce.ports.repository.purchase.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllPurchasesUseCase {
    private final PurchaseRepository repository;
    private final PurchaseResponseMapper mapper;

    public FindAllPurchasesUseCase(PurchaseRepository repository, PurchaseResponseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<PurchaseResponse> execute() {
        List<Purchase> purchases = repository.findAll();

        return purchases.stream()
                .map(mapper::toDTO)
                .toList();
    }
}
