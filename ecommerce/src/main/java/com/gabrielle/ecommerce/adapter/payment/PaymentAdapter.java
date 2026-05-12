package com.gabrielle.ecommerce.adapter.payment;

import com.gabrielle.ecommerce.application.mapper.payment.PaymentPersistenceMapper;
import com.gabrielle.ecommerce.domain.Payment;
import com.gabrielle.ecommerce.domain.entity.PaymentEntity;
import com.gabrielle.ecommerce.ports.repository.payment.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PaymentAdapter implements PaymentRepository {
    private final PaymentJpaRepository repository;
    private final PaymentPersistenceMapper mapper;

    public PaymentAdapter(PaymentJpaRepository repository, PaymentPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Payment save(Payment payment) {
        PaymentEntity entity = mapper.toEntity(payment);
        PaymentEntity saved = repository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Payment> findByExternalId(String externalId) {
        Optional<PaymentEntity> entity = repository.findByExternalId(externalId);
        return entity.map(mapper::toDomain);
    }
}
