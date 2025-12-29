package com.gabrielle.ecommerce.ports.repository.purchase;

import com.gabrielle.ecommerce.domain.entity.Purchase.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PurchaseJpaRepository extends JpaRepository<PurchaseEntity, UUID> {}
