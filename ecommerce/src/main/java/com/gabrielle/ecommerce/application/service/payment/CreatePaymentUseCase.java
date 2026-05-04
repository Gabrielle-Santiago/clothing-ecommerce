package com.gabrielle.ecommerce.application.service.payment;

import com.gabrielle.ecommerce.application.dto.payment.*;
import com.gabrielle.ecommerce.application.mapper.payment.PaymentResponseMapper;
import com.gabrielle.ecommerce.domain.Payment;
import com.gabrielle.ecommerce.domain.Purchase;
import com.gabrielle.ecommerce.ports.repository.payment.PaymentRepository;
import com.gabrielle.ecommerce.ports.repository.purchase.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class CreatePaymentUseCase {
    public final PaymentRepository paymentRepository;
    public final PaymentResponseMapper mapper;
    public final PurchaseRepository purchaseRepository;

    public CreatePaymentUseCase(PaymentRepository paymentRepository, PaymentResponseMapper mapper, PurchaseRepository purchaseRepository) {
        this.paymentRepository = paymentRepository;
        this.mapper = mapper;
        this.purchaseRepository = purchaseRepository;
    }

    public PaymentResponse execute(PaymentRequest request){
        Purchase purchase = purchaseRepository.findById(request.purchaseId());


        UUID purchaseId = purchase.getId();
        BigDecimal amount = purchase.getTotal();
        String email = request.payerEmail();

        Payment payment = Payment.create(purchaseId, email, amount);
        Payment savePayment = paymentRepository.save(payment);

        return mapper.toDTO(savePayment);
    }
}
