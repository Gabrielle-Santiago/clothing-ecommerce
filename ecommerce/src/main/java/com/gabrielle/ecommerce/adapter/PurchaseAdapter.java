package com.gabrielle.ecommerce.adapter;

import com.gabrielle.ecommerce.application.mapper.purchase.PurchasePersistenceMapper;
import com.gabrielle.ecommerce.domain.Purchase;
import com.gabrielle.ecommerce.domain.entity.Purchase.PurchaseEntity;
import com.gabrielle.ecommerce.ports.repository.purchase.PurchaseJpaRepository;
import com.gabrielle.ecommerce.ports.repository.purchase.PurchaseRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PurchaseAdapter implements PurchaseRepository {
    private final PurchaseJpaRepository repository;
    private final PurchasePersistenceMapper mapper;

    public PurchaseAdapter(PurchaseJpaRepository repository, PurchasePersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Purchase save(Purchase purchase) {
        PurchaseEntity entity = mapper.toEntity(purchase);

        if (entity.getItems() != null) {
            entity.getItems().forEach(item -> item.setPurchase(entity));
        }

        PurchaseEntity saveEntity = repository.save(entity);
        return mapper.toDomain(saveEntity);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<Purchase> findAll() {
        List<PurchaseEntity> entity = repository.findAll();
        return entity.stream().map(mapper::toDomain).toList();
    }
}
