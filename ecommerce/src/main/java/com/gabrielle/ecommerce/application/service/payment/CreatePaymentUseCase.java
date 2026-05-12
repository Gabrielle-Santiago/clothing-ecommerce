package com.gabrielle.ecommerce.application.service.payment;

import com.gabrielle.ecommerce.application.dto.payment.*;
import com.gabrielle.ecommerce.application.dto.purchase.PurchasePaymentData;
import com.gabrielle.ecommerce.application.mapper.payment.PaymentResponseMapper;
import com.gabrielle.ecommerce.domain.Payment;
import com.gabrielle.ecommerce.ports.repository.payment.PaymentGatewayRepository;
import com.gabrielle.ecommerce.ports.repository.payment.PaymentRepository;
import com.gabrielle.ecommerce.ports.repository.purchase.PurchaseRepository;
import org.springframework.stereotype.Service;

@Service
public class CreatePaymentUseCase {

    private final PaymentRepository paymentRepository;
    private final PurchaseRepository purchaseRepository;
    private final PaymentGatewayRepository paymentGateway;
    private final PaymentResponseMapper mapper;

    public CreatePaymentUseCase(PaymentRepository paymentRepository, PurchaseRepository purchaseRepository,
            PaymentGatewayRepository paymentGateway, PaymentResponseMapper mapper)
    {
        this.paymentRepository = paymentRepository;
        this.purchaseRepository = purchaseRepository;
        this.paymentGateway = paymentGateway;
        this.mapper = mapper;
    }

    public PaymentResponse execute(PaymentRequest request) {
        PurchasePaymentData purchaseData =
                purchaseRepository.findPaymentDataById(request.purchaseId());

        Payment payment = Payment.create(purchaseData.purchaseId(), request.payerEmail(), purchaseData.total());

        PaymentGatewayResponse gatewayResponse = paymentGateway.createPayment(payment);
        payment.updatePaymentData(gatewayResponse.checkoutUrl(), gatewayResponse.externalId());

        Payment saved = paymentRepository.save(payment);

        return mapper.toDTO(saved);
    }
}
