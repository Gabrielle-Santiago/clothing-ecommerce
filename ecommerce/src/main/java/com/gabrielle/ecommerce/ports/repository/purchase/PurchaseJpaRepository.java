package com.gabrielle.ecommerce.ports.repository.purchase;

import com.gabrielle.ecommerce.application.dto.purchase.PurchasePaymentData;
import com.gabrielle.ecommerce.domain.entity.Purchase.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface PurchaseJpaRepository extends JpaRepository<PurchaseEntity, UUID> {
    @Query("""
        SELECT new com.gabrielle.ecommerce.application.dto.purchase.PurchasePaymentData(
            p.id,
            p.total
        )
        FROM PurchaseEntity p
        WHERE p.id = :id
    """)
    Optional<PurchasePaymentData> findPaymentDataById(UUID id);
}
