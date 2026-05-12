package com.gabrielle.ecommerce.ports.repository.payment;

import com.gabrielle.ecommerce.application.dto.payment.PaymentGatewayResponse;
import com.gabrielle.ecommerce.domain.Payment;

public interface PaymentGatewayRepository {
    PaymentGatewayResponse createPayment(Payment payment);
}
