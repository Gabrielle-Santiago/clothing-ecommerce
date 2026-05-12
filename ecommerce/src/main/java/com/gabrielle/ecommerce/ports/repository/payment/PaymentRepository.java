package com.gabrielle.ecommerce.ports.repository.payment;

import com.gabrielle.ecommerce.domain.Payment;

import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository {
    Payment save(Payment payment);
    Optional<Payment> findByExternalId(String externalId);
}
