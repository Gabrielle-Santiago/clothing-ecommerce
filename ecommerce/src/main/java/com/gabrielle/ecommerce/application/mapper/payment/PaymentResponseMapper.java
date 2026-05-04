package com.gabrielle.ecommerce.application.mapper.payment;

import com.gabrielle.ecommerce.application.dto.payment.PaymentResponse;
import com.gabrielle.ecommerce.domain.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentResponseMapper {
    PaymentResponse toDTO(Payment domain);
}
