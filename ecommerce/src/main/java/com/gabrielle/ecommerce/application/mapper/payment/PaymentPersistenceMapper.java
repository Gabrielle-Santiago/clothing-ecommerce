package com.gabrielle.ecommerce.application.mapper.payment;

import com.gabrielle.ecommerce.domain.Payment;
import com.gabrielle.ecommerce.domain.entity.PaymentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentPersistenceMapper {
    PaymentEntity toEntity(Payment domain);

    default Payment toDomain(PaymentEntity entity) {
        return Payment.restore(
                entity.getId(),
                entity.getStatus(),
                entity.getPurchaseId(),
                entity.getCheckoutUrl(),
                entity.getPayerEmail(),
                entity.getAmount(),
                entity.getExternalId()
        );
    }
}
