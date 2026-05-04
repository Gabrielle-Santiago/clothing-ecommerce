package com.gabrielle.ecommerce.ports.repository.payment;

import com.gabrielle.ecommerce.domain.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PaymentJpaRepository extends JpaRepository<PaymentEntity, UUID> {
    Optional<PaymentEntity> findByExternalId(String externalId);
}
